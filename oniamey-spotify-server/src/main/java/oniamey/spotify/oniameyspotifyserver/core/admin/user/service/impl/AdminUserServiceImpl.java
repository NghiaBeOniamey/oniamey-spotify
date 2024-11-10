package oniamey.spotify.oniameyspotifyserver.core.admin.user.service.impl;

import lombok.RequiredArgsConstructor;
import oniamey.spotify.oniameyspotifyserver.core.admin.user.model.request.AdminFindUserRequest;
import oniamey.spotify.oniameyspotifyserver.core.admin.user.model.request.AdminUserRequest;
import oniamey.spotify.oniameyspotifyserver.core.admin.user.repository.AdminUserRepository;
import oniamey.spotify.oniameyspotifyserver.core.admin.user.service.AdminUserService;
import oniamey.spotify.oniameyspotifyserver.core.common.base.PageableObject;
import oniamey.spotify.oniameyspotifyserver.core.common.base.ResponseObject;
import oniamey.spotify.oniameyspotifyserver.entity.User;
import oniamey.spotify.oniameyspotifyserver.infrastructure.constant.AuthProvider;
import oniamey.spotify.oniameyspotifyserver.infrastructure.constant.Role;
import oniamey.spotify.oniameyspotifyserver.infrastructure.constant.Status;
import oniamey.spotify.oniameyspotifyserver.infrastructure.constant.module.Message;
import oniamey.spotify.oniameyspotifyserver.util.Helper;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminUserServiceImpl implements AdminUserService {

    private final AdminUserRepository userRepository;

    @Override
    public ResponseObject<?> getUsers(AdminFindUserRequest request) {
        try {
            Pageable pageable = Helper.createPageable(request);
            return new ResponseObject<>(
                    PageableObject.of(userRepository.getUsers(pageable, request)),
                    HttpStatus.OK,
                    Message.Success.GET_SUCCESS
            );
        } catch (Exception e) {
            return ResponseObject.errorForward(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getMessage()
            );
        }
    }

    @Override
    public ResponseObject<?> getUserById(String id) {
        try {
            return new ResponseObject<>(
                    userRepository.findUserById(id),
                    HttpStatus.OK,
                    Message.Success.GET_SUCCESS
            );
        } catch (Exception e) {
            return ResponseObject.errorForward(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getMessage()
            );
        }
    }

    @Override
    public ResponseObject<?> createUser(AdminUserRequest request) {
        try {
            if (userRepository.existsByEmail(request.getEmail())) {
                return ResponseObject.errorForward(
                        HttpStatus.BAD_REQUEST,
                        Message.Response.DUPLICATE + ", email"
                );
            }
            User newUser = new User();
            newUser.setUserName(request.getUserName());
            newUser.setEmail(request.getEmail());
            newUser.setPassword(request.getPassword());
            newUser.setSubscriptionType(AuthProvider.admin.name());
            newUser.setProfilePicture(request.getProfilePicture());
            Role role = request.getRole() == 0 ? Role.USER : Role.ADMIN;
            newUser.setRole(role);
            newUser.setStatus(Status.ACTIVE);
            userRepository.save(newUser);
            return ResponseObject.successForward(
                    HttpStatus.CREATED,
                    Message.Success.CREATE_SUCCESS
            );
        } catch (Exception e) {
            return ResponseObject.errorForward(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getMessage()
            );
        }
    }

    @Override
    public ResponseObject<?> updateUser(String id, AdminUserRequest request) {
        try {
            Optional<User> userOptional = userRepository.findById(id);
            if (userOptional.isEmpty()) {
                return ResponseObject.errorForward(
                        HttpStatus.BAD_REQUEST,
                        Message.Response.NOT_FOUND + ", người dùng"
                );
            }
            User newUser = userOptional.get();
            if (!newUser.getEmail().equals(request.getEmail()) &&
                    userRepository.existsByEmail(request.getEmail())) {
                return ResponseObject.errorForward(
                        HttpStatus.BAD_REQUEST,
                        Message.Response.DUPLICATE + ", email"
                );
            }
            newUser.setUserName(request.getUserName());
            newUser.setEmail(request.getEmail());
            newUser.setPassword(request.getPassword());
            newUser.setProfilePicture(request.getProfilePicture());
            Role role = request.getRole() == 0 ? Role.USER : Role.ADMIN;
            newUser.setRole(role);
            userRepository.save(newUser);
            return ResponseObject.successForward(
                    HttpStatus.CREATED,
                    Message.Success.UPDATE_SUCCESS
            );
        } catch (Exception e) {
            return ResponseObject.errorForward(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getMessage()
            );
        }
    }

    @Override
    public ResponseObject<?> changeStatusUser(String id) {
        try {
            Optional<User> userOptional = userRepository.findById(id);
            if (userOptional.isEmpty()) {
                return ResponseObject.errorForward(
                        HttpStatus.BAD_REQUEST,
                        Message.Response.NOT_FOUND + ", người dùng"
                );
            }
            User newUser = userOptional.get();
            Status status = newUser.getStatus() == Status.ACTIVE ? Status.INACTIVE : Status.ACTIVE;
            newUser.setStatus(status);
            userRepository.save(newUser);
            return ResponseObject.successForward(
                    HttpStatus.CREATED,
                    Message.Success.UPDATE_SUCCESS
            );
        } catch (Exception e) {
            return ResponseObject.errorForward(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getMessage()
            );
        }
    }
}
