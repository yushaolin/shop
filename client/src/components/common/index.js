import head from './head.vue'
import login from './login.vue'
export default {
  install(Vue) {
    Vue.component('app-head', head);
    Vue.component('app-login', login);
  }
}
