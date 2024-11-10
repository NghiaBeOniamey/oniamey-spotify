<template>
  <div class="redirect-container">
    <p class="redirect-message">Redirecting...</p>
  </div>
</template>

<script setup lang="ts">
import { useAuthStore } from "@/infrastructure/stores/auth.ts";
import { getUserInformation } from "@/utils/token.helper.ts";
import { onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";

const route = useRoute();

const router = useRouter();

const authStore = useAuthStore();

const { state } = route.query;

onMounted(() => {
  if (state) {
    const decodedState = atob(state as string);

    const { accessToken, refreshToken } = JSON.parse(decodedState);

    const user = getUserInformation(accessToken);

    authStore.login({
      user,
      accessToken,
      refreshToken,
    });

    router.push({ name: "role-switch" });
    return;
  }
  router.push({ name: "login" });
});
</script>

<style scoped>
.redirect-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-color: #f0f0f0;
}

.redirect-message {
  font-size: 1.5rem;
  color: #333;
  font-weight: bold;
}
</style>
