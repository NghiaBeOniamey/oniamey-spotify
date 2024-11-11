import {PREFIX_API_USER_ADMIN} from "@/infrastructure/constants/url";
import request from "@/infrastructure/services/request";
import {DefaultResponse, PaginationParams, PaginationResponse, ResponseList} from "@/infrastructure/types/api.common";
import {AxiosResponse} from "axios";
import {Ref} from "vue";

export interface FindUserRequest extends PaginationParams {
    keyword: string | null;
    status: number | null;
    role: number | null;
    subscriptionType: number | null;
}

export interface UserRequest {
    name: string;
    email: string;
    password: string;
    subscriptionType: number;
    profilePicture: string;
    role: number;
    status: number;
}

export type UserResponse = ResponseList & {
    name: string;
    email: string;
    password: string;
    subscriptionType: number;
    profilePicture: string;
    role: number;
    status: number;
};


export const getUsers = async (params: Ref<FindUserRequest>) => {
    const res = (await request({
        url: `${PREFIX_API_USER_ADMIN}`,
        method: "GET",
        params: params.value,
    })) as AxiosResponse<
        DefaultResponse<PaginationResponse<Array<UserResponse>>>
    >;

    return res.data;
};

export const createUser = async (data: UserRequest) => {
    const res = (await request({
        url: `${PREFIX_API_USER_ADMIN}`,
        method: "POST",
        data: data
    })) as AxiosResponse<
        DefaultResponse<DefaultResponse<null>>
    >;

    return res.data;
};

export const getUser = async (userId: Ref<string>) => {
    return await request({
        url: `${PREFIX_API_USER_ADMIN}/${userId}`,
        method: "GET"
    }) as AxiosResponse<
        DefaultResponse<PaginationResponse<Array<UserResponse>>>
    >;
};

export const updateUser = async (userId: string, data: UserRequest) => {
    return await request({
        url: `${PREFIX_API_USER_ADMIN}/${userId}`,
        method: "PUT",
        data: data
    }) as AxiosResponse<
        DefaultResponse<DefaultResponse<null>>
    >;
};

export const changeStatusUser = async (userId: Ref<string>) => {
    return await request({
        url: `${PREFIX_API_USER_ADMIN}/${userId}`,
        method: "DELETE",
    }) as AxiosResponse<
        DefaultResponse<DefaultResponse<null>>
    >;
};
