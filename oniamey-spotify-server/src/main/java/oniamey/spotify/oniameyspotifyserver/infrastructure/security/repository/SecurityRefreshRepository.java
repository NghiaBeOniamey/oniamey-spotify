package oniamey.spotify.oniameyspotifyserver.infrastructure.security.repository;

import oniamey.spotify.oniameyspotifyserver.entity.RefreshToken;
import oniamey.spotify.oniameyspotifyserver.repository.RefreshRepository;

import java.util.Optional;

public interface SecurityRefreshRepository extends RefreshRepository {

    Optional<RefreshToken> findByRefreshToken(String refreshToken);

    Optional<RefreshToken> findByUserId(String userId);

    int deleteByUserId(String userId);
    

}
