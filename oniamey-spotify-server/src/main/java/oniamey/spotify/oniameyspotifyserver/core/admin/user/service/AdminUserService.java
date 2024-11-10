package oniamey.spotify.oniameyspotifyserver.core.admin.user.service;

import jakarta.validation.Valid;
import oniamey.spotify.oniameyspotifyserver.core.admin.user.model.request.AdminFindUserRequest;
import oniamey.spotify.oniameyspotifyserver.core.admin.user.model.request.AdminUserRequest;
import oniamey.spotify.oniameyspotifyserver.core.common.base.ResponseObject;

public interface AdminUserService {

    ResponseObject<?> getUsers(AdminFindUserRequest request);

    ResponseObject<?> getUserById(String id);

    ResponseObject<?> createUser(@Valid AdminUserRequest request);

    ResponseObject<?> updateUser(String id, @Valid AdminUserRequest request);

    ResponseObject<?> changeStatusUser(String id);

}
