// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import axios from 'axios'
import iview from 'iview'
import App from './App'
import router from './router'
import common from './components/common'
import store from './store'
Vue.config.productionTip = false
Vue.prototype.$http = axios
Vue.use(common)
Vue.use(iview);
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
