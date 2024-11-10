package oniamey.spotify.oniameyspotifyserver.infrastructure.listener;

import jakarta.persistence.PrePersist;
import oniamey.spotify.oniameyspotifyserver.entity.base.PrimaryEntity;

import java.util.UUID;

public class CreatePrimaryEntityListener {

    @PrePersist
    private void onCreate(PrimaryEntity entity) {
        entity.setId(UUID.randomUUID().toString());
    }

}
