package oniamey.spotify.oniameyspotifyserver.infrastructure.constant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum InteractionType {

    PLAY_BACK,

    LIKE,

    SKIP;

    public static List<String> InteractionTypes() {
        return Arrays.stream(InteractionType.values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }

}
