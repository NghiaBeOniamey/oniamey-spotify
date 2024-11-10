package oniamey.spotify.oniameyspotifyserver.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import oniamey.spotify.oniameyspotifyserver.entity.base.PrimaryEntity;
import oniamey.spotify.oniameyspotifyserver.infrastructure.constant.Status;

import java.io.Serializable;

@Entity
@Table(name = "song")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Song extends PrimaryEntity implements Serializable {

    @Column(length = 255, nullable = false)
    private String title;

    @Column(length = 255, nullable = false)
    private String artist;

    private Long duration;

    @Column(length = 100)
    private String genre;

    private Long releaseDate;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @Column(length = 255)
    private String audioFile;

}
