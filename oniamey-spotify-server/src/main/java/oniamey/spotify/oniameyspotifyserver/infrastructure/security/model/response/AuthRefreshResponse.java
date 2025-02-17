package oniamey.spotify.oniameyspotifyserver.infrastructure.security.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthRefreshResponse {

    private String accessToken;

    private String refreshToken;

}
