package oniamey.spotify.oniameyspotifyserver.repository;

import oniamey.spotify.oniameyspotifyserver.entity.PlaylistSong;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistSongRepository extends JpaRepository<PlaylistSong, String> {
}
