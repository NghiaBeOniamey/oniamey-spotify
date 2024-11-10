package oniamey.spotify.oniameyspotifyserver.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import oniamey.spotify.oniameyspotifyserver.entity.base.PrimaryEntity;
import oniamey.spotify.oniameyspotifyserver.infrastructure.constant.InteractionType;
import oniamey.spotify.oniameyspotifyserver.infrastructure.constant.Status;

import java.io.Serializable;

@Entity
@Table(name = "playlist")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Playlist extends PrimaryEntity implements Serializable {

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "user_id")
    private User userId;

    @Column(length = 255)
    private String title;

    @Column(length = 1000)
    private String description;

    @Column(length = 50)
    private String privacySetting;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    // has creationDate



}
