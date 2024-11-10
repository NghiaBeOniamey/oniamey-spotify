export const ROUTES_CONSTANTS = {
    AUTHENTICATION: {
        path: "/authentication",
        name: "authentication",
        children: {
            LOGIN: {
                path: "login",
                name: "login",
            },
            REGISTER: {
                path: "register",
                name: "register",
            },
            FORGOT_PASSWORD: {
                path: "forgot-password",
                name: "forgot-password",
            },
        }
    },
    ADMIN: {
        path: "/admin",
        name: "admin",
        children: {
            FEATURE: {
                path: "feature",
                name: "feature",
            },
        },
    },
    ROLE_SWITCH: {
        path: "/role-switch",
        name: "role-switch",
    },
    USER: {
        path: "/user",
        name: "user",
        children: {
            FEATURE: {
                path: "feature",
                name: "feature",
            }
        },
    },
    NOT_FOUND: {
        path: "/:pathMatch(.*)*",
        name: "NotFound",
    },
    REDIRECT: {
        path: "/redirect",
        name: "redirect",
    },
};
