package oniamey.spotify.oniameyspotifyserver.repository;

import oniamey.spotify.oniameyspotifyserver.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshRepository extends JpaRepository<RefreshToken, String> {
}
