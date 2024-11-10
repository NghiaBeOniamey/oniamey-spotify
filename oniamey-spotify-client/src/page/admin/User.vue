<template>
  <div class="p-6 grid grid-cols-1 gap-6">
    <div class="flex items-center gap-2">
      <v-icon name="fa-users-cog" size="x-large" width="48" height="48"/>
      <h3 class="text-2xl m-0">Quản lý người dùng</h3>
    </div>
    <div class="p-4 rounded-xl border-2 shadow-purple-950 shadow-2xl flex flex-col h-48 gap-3">
      <div class="basis-1/6">
        <div class="flex items-center gap-2">
          <v-icon name="si-iconfinder" size="x-large" width="24" height="24"/>
          <h4 class="text-xl m-0">Bộ lọc</h4>
        </div>
      </div>
      <div class="basis-4/6 py-3">

      </div>
    </div>
    <div class="p-4 bg-blue-900 rounded-xl border-2 drop-shadow-2xl">
      <div>

      </div>
    </div>
  </div>
</template>

<script lang="ts">
export default {
  name: 'user-management',
};
</script>

<script lang="ts" setup>

</script>