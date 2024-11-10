package oniamey.spotify.oniameyspotifyserver.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import oniamey.spotify.oniameyspotifyserver.entity.base.PrimaryEntity;

import java.io.Serializable;

@Entity
@Table(name = "playlist_song")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlaylistSong extends PrimaryEntity implements Serializable {

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "playlist_id")
    private Playlist playlistId;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "song_id")
    private Song songId;

}
