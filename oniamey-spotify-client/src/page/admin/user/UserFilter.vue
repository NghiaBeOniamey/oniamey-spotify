<template>
    <a-form
        layout="vertical"
        class="mb-4 grid grid-cols-1 gap-4 md:grid-cols-2 lg:grid-cols-2 p-5"
    >
      <a-form-item
          label="Học kỳ"
          class="col-span-1 md:col-span-1 lg:col-span-1"
      >
        <a-select
            :value="params.semesterId"
            @change="onSelectChange('semesterId', $event)"
            placeholder="Chọn học kỳ"
            allowClear
        >
          <a-select-option
              v-for="option in props.semesterOptions"
              :key="option.value"
              :value="option.value"
          >
            {{ option.label }}
          </a-select-option>
        </a-select>
      </a-form-item>
      <a-form-item
          label="Trạng thái"
          class="col-span-1 md:col-span-1 lg:col-span-1"
      >
        <a-select
            :value="params.planStatus"
            @change="onSelectChange('planStatus', $event)"
            placeholder="Chọn trạng thái"
            allowClear
        >
          <a-select-option
              v-for="option in PlanStatusOptions"
              :key="option.value"
              :value="option.value"
          >
            {{ option.label }}
          </a-select-option>
        </a-select>
      </a-form-item>
    </a-form>
</template>

<script setup lang="ts">
import { debounce } from "lodash";
import { defineEmits, ref, watch } from "vue";

const emit = defineEmits(["filter"]);

const props = defineProps

const debouncedEmit = debounce(() => {
  emit("filter", params.value);
}, 2000);

function onSelectChange(key: keyof ParamsFilterSubjects, value: string) {
  params.value[key] = value;
  emit("filter", params.value);
}

watch(
    params,
    () => {
      debouncedEmit();
    },
    { deep: true }
);
</script>

<style scoped>

</style>