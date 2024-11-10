package oniamey.spotify.oniameyspotifyserver.infrastructure.constant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Status {

    ACTIVE,

    INACTIVE;

    public static List<String> InteractionTypes() {
        return Arrays.stream(Status.values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }

}
