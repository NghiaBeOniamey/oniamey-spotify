package oniamey.spotify.oniameyspotifyserver.infrastructure.security.repository;

import oniamey.spotify.oniameyspotifyserver.entity.User;
import oniamey.spotify.oniameyspotifyserver.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SecurityUserRepository extends UserRepository {

    Optional<User> findByEmail(String email);

}
