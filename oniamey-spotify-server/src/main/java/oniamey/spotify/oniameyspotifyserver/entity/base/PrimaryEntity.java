package oniamey.spotify.oniameyspotifyserver.entity.base;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import oniamey.spotify.oniameyspotifyserver.infrastructure.constant.module.EntityProperties;
import oniamey.spotify.oniameyspotifyserver.infrastructure.listener.CreatePrimaryEntityListener;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(CreatePrimaryEntityListener.class)
public abstract class PrimaryEntity extends AuditEntity implements IsIdentified{

    @Id
    @Column(length = 36, updatable = false)
    private String id;

}