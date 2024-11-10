package oniamey.spotify.oniameyspotifyserver.repository;

import oniamey.spotify.oniameyspotifyserver.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, String> {
}
