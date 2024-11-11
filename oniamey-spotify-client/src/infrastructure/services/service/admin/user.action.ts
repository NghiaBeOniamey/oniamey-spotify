import {
    changeStatusUser,
    createUser,
    FindUserRequest,
    getUser,
    getUsers,
    updateUser,
    UserRequest
} from "@/infrastructure/services/api/admin/user.api.ts";
import {useMutation, useQuery, useQueryClient, UseQueryReturnType} from "@tanstack/vue-query";
import {queryKey} from "@/infrastructure/constants/queryKey.ts";
import {Ref} from "vue";


export const useGetUsers = (
    params: Ref<FindUserRequest>, options?: any
): UseQueryReturnType<Awaited<ReturnType<typeof getUsers>>, Error> => {
    return useQuery({
        queryKey: [queryKey.admin.user.userList, params],
        queryFn: () => getUsers(params),
        ...options,
    });
};

export const useCreateUser = () => {
    const queryClient = useQueryClient();
    return useMutation({
        mutationFn: (data: UserRequest) => createUser(data),
        onSuccess: () => {
            queryClient.invalidateQueries({
                queryKey: [queryKey.admin.user.userCreate],
            })
        },
        onError: (error: any) => {
            console.log(queryKey.admin.user.userCreate, "🚀 ~ userCreate ~ error:", error);
        },
    });
};


export const useGetUser = (
    userId: Ref<string>, options?: any
): UseQueryReturnType<Awaited<ReturnType<typeof getUser>>, Error> => {
    return useQuery({
        queryKey: [queryKey.admin.user.userDetail, userId,],
        queryFn: () => getUser(userId),
        ...options,
    });
};


export const useUpdateUser = () => {
    const queryClient = useQueryClient();
    return useMutation({
        mutationFn: ({userId, data,}: { userId: string; data: UserRequest; }) => updateUser(userId, data),
        onSuccess: () => {
            queryClient.invalidateQueries({queryKey: [queryKey.admin.user.userUpdate],});
        },
        onError: (error: any) => {
            console.log(queryKey.admin.user.userUpdate + "🚀 ~ userUpdate ~ error:", error);
        },
    });
};

export const useChangeStatusUser = (
    userId: Ref<string>, options?: any
): UseQueryReturnType<Awaited<ReturnType<typeof changeStatusUser>>, Error> => {
    return useQuery({
        queryKey: [queryKey.admin.user.userDelete, userId],
        queryFn: () => changeStatusUser(userId),
        ...options,
    });
};