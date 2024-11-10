package oniamey.spotify.oniameyspotifyserver.repository;

import oniamey.spotify.oniameyspotifyserver.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepository extends JpaRepository<Follow, String> {
}
