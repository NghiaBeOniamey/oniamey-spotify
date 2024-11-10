import dayjs from "dayjs";
import {Modal} from "ant-design-vue";
import {ExclamationCircleOutlined} from "@ant-design/icons-vue";
import {createVNode} from "vue";

export function sortObjectKeys(obj: Record<string, any>) {
  if (!obj) return obj;

  return sortAlphaText(Object.keys(obj)).reduce((acc, key) => {
    // @ts-ignore
    acc[key] = obj[key];

    return acc;
  }, {});
}

export function sortAlphaText(arr: string[], type?: "asc" | "desc") {
  if (!arr) return arr;

  return arr.sort((a, b) => {
    return a.localeCompare(b) * (type === "asc" ? 1 : -1);
  });
}

export const getDateFormat = (unix: number, showTime: boolean = false) => {
  return dayjs(unix).format(showTime ? "DD/MM/YYYY HH:mm:ss" : "DD/MM/YYYY");
};

export const getTagColor = (status: string): string => {
  switch (status) {
    case 'PLANNING':
      return 'warning';
    case 'PLANNER_APPROVED':
      return 'grey';
    case 'HEAD_DEPARTMENT_APPROVED':
      return 'blue';
    case 'IN_PROGRESS':
      return 'processing';
    case 'DONE':
      return 'success';
    default:
      return 'default';
  }
};

export const getTagStatus = (status: string): string => {
  switch (status) {
    case 'PLANNING':
      return 'Đang lên kế hoạch';
    case 'PLANNER_APPROVED':
      return 'Người lập kế hoạch thông qua';
    case 'HEAD_DEPARTMENT_APPROVED':
      return 'Chủ nhiệm thông qua';
    case 'IN_PROGRESS':
      return 'Đang thực hiện';
    case 'DONE':
      return 'Đã xong';
    default:
      return 'default';
  }
};

export const formatBlockName = (blockName: string): string => {
  return blockName.replace(/^BLOCK_/, 'Block ');
};

export const filterOption = (input: string, option: any) => {
  return option.value.toLowerCase().includes(input.toLowerCase());
};

export const confirmModal = (message, onConfirm) => {
  Modal.confirm({
    content: message,
    icon: createVNode(ExclamationCircleOutlined),
    centered: true,
    onOk() {
      onConfirm();
    },
    cancelText: 'Huỷ',
    onCancel() {
      Modal.destroyAll();
    },
  });
};