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
import oniamey.spotify.oniameyspotifyserver.infrastructure.constant.Role;
import oniamey.spotify.oniameyspotifyserver.infrastructure.constant.Status;

import java.io.Serializable;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User extends PrimaryEntity implements Serializable {

    @Column(length = 50, nullable = false)
    private String userName;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 50)
    private String subscriptionType;

    @Column(length = 255)
    private String profilePicture;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @Enumerated(EnumType.ORDINAL)
    private Role role;

}
