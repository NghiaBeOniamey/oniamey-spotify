package oniamey.spotify.oniameyspotifyserver.infrastructure.security.service;

import jakarta.transaction.Transactional;
import oniamey.spotify.oniameyspotifyserver.entity.RefreshToken;
import oniamey.spotify.oniameyspotifyserver.entity.User;
import oniamey.spotify.oniameyspotifyserver.infrastructure.security.repository.SecurityRefreshRepository;
import oniamey.spotify.oniameyspotifyserver.infrastructure.security.repository.SecurityUserRepository;
import oniamey.spotify.oniameyspotifyserver.infrastructure.security.oauth2.user.UserPrincipal;
import oniamey.spotify.oniameyspotifyserver.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class RefreshTokenService {

    // 6 hours
    private final long REFRESH_EXPIRED_TIME = 6 * 60 * 60 * 1000;

    private final SecurityRefreshRepository refreshRepository;

    private final SecurityUserRepository userRepository;

    @Autowired
    public RefreshTokenService(
            SecurityRefreshRepository refreshRepository,
            SecurityUserRepository userAuthRepository
    ) {
        this.refreshRepository = refreshRepository;
        this.userRepository = userAuthRepository;
    }

    public Optional<RefreshToken> findByToken(String refreshToken) {
        return refreshRepository.findByRefreshToken(refreshToken);
    }

    public RefreshToken createRefreshToken(Authentication authentication) {
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        Optional<User> user = userRepository.findByEmail(userPrincipal.getEmail());
        Optional<RefreshToken> optionalRefreshToken = refreshRepository.findByUserId(userPrincipal.getId());

        if (optionalRefreshToken.isPresent()) {
            return getRefreshToken(optionalRefreshToken);
        }

        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setUserId(userPrincipal.getId());
        refreshToken.setExpiredAt(REFRESH_EXPIRED_TIME);
        refreshToken.setRefreshToken(UUID.randomUUID().toString());
        refreshToken = refreshRepository.save(refreshToken);
        return refreshToken;
    }

    private RefreshToken getRefreshToken(Optional<RefreshToken> optionalRefreshToken) {
        RefreshToken refreshToken = optionalRefreshToken.get();
        if (refreshToken.getRevokedAt() != null) {
            refreshToken.setRevokedAt(null);
            refreshToken.setExpiredAt(REFRESH_EXPIRED_TIME);
            refreshToken.setRefreshToken(UUID.randomUUID().toString());
            return refreshRepository.save(optionalRefreshToken.get());
        }
        refreshToken.setExpiredAt(REFRESH_EXPIRED_TIME);
        refreshToken.setRefreshToken(UUID.randomUUID().toString());
        return refreshRepository.save(refreshToken);
    }

    public RefreshToken createRefreshToken(String userId) {
        Optional<RefreshToken> optionalRefreshToken = refreshRepository.findByUserId(userId);
        if (optionalRefreshToken.isPresent()) {
            return getRefreshToken(optionalRefreshToken);
        }

        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setUserId(userId);
        refreshToken.setExpiredAt(REFRESH_EXPIRED_TIME);
        refreshToken.setRefreshToken(UUID.randomUUID().toString());
        refreshToken = refreshRepository.save(refreshToken);
        return refreshToken;
    }

    public RefreshToken verifyExpiration(RefreshToken token) {
        if (token.getExpiredAt() < DateTimeUtil.convertDateToTimeStampSecond(new Date())) {
            refreshRepository.delete(token);
            return null;
        }
        return token;
    }

    @Transactional
    public int deleteByUserId(String userId) {
        return refreshRepository.deleteByUserId(userId);
    }

}
