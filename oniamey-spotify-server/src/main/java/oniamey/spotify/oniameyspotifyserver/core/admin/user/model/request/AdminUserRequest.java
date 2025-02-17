package oniamey.spotify.oniameyspotifyserver.core.admin.user.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import oniamey.spotify.oniameyspotifyserver.infrastructure.constant.module.Message;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminUserRequest {

    @NotBlank(message = Message.Validate.NOT_BLANK)
    @Size(min = 8, max = 50, message = Message.Validate.SIZE50)
    private String userName;

    @NotBlank(message = Message.Validate.NOT_BLANK)
    @Email(message = Message.Validate.IS_EMAIL)
    private String email;

    @NotBlank(message = Message.Validate.NOT_BLANK)
    @Size(min = 8, max = 50, message = Message.Validate.SIZE50)
    private String password;

    @NotBlank(message = Message.Validate.NOT_BLANK)
    @Size(min = 8, max = 100, message = Message.Validate.SIZE100)
    private String profilePicture;

    @NotBlank(message = Message.Validate.NOT_BLANK)
    private Integer role;

}
