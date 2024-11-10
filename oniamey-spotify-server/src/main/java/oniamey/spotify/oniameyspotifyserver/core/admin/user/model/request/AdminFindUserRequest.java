package oniamey.spotify.oniameyspotifyserver.core.admin.user.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import oniamey.spotify.oniameyspotifyserver.core.common.base.PageableRequest;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminFindUserRequest extends PageableRequest {

    private String keyword;

    private Integer status;

    private Integer role;

    private Integer subscriptionType;

}
