import head from '@/components/common/head.vue'
import login from '@/components/common/login.vue'
export default {
  install(Vue) {
    Vue.component('app-head', head);
    Vue.component('app-login', login);
  }
}
