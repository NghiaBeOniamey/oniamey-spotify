package oniamey.spotify.oniameyspotifyserver.infrastructure.constant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Role {

    USER,

    ADMIN;

    public static List<String> InteractionTypes() {
        return Arrays.stream(Role.values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }

}
