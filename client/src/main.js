// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import iview from 'iview'
import VueLazyLoad from 'vue-lazyload'

import App from './App'
import router from './router'
import common from './assets/js/initComponents'
import store from './store'
import {currency} from './assets/js/currency'
import 'iview/dist/styles/iview.css';
import '../static/css/public.scss'
import '../static/css/input.scss'
import '../static/css/modal.scss'
import '../static/css/carousel.scss'

Vue.config.productionTip = false
Vue.use(common)
Vue.use(iview);
Vue.filter('currency', currency)
Vue.use(VueLazyLoad, {
  loading: '/static/loading-svg/loading-bars.svg'
});
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
