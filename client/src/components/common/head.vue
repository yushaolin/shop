<template>
  <div class="site-topbar">
    <div class="container flex">
      <div class="left"></div>
      <div class="flex">
        <div class="topbar-info">
          <a class="link login" @click="openModal(0)">登陆</a>
          <span class='sep'>|</span>
          <a class="link" @click="openModal(1)">注册</a>
        </div>
        <div class="topbar-cart">
          <router-link to="/cart">
            <a href="/cart">
              <i class="icon-cart"></i>
              购物车(0)
            </a>
          </router-link>
        </div>
      </div>
    </div>
    <app-login :show="modalShow" :modalConfig="modalConfig" :cancel="cancel" :type="userOpenType"></app-login>
  </div>
</template>

<script>
export default {
  name: 'head',
  data () {
    return {
      modalShow: false,
      modalConfig: {
        width: 410,
        height: 308
      },
      userOpenType: 0
    }
  },
  methods: {
    /**
     * @param type 用户打开类型
     */
    openModal(type) {
      this.userOpenType = type
      this.modalShow = true;
    },
    cancel() {
      this.modalShow = false;
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
.site-topbar{
  position: relative;
  background: #333;
  color: #b0b0b0;
  height: 40px;
  font-size: 14px;
  .right{
    text-align: right;
  }
  .link{
    padding: 0 5px;
    cursor: pointer;
    color: #b0b0b0;
    &:hover{
      color: #b0b0b0;
    }
  }
  .topbar-cart{
    margin-left: 15px;
    a {
      display: block;
      position: relative;
      color: #b0b0b0;
      background: #424242;
      margin-left: 5px;
      height: 40px;
      line-height: 40px;
      padding: 0 20px;
      i {
        background-image: url('/static/img/cart.png');
        background-size: 17px 17px;
        width: 17px;
        height: 17px;
        display: inline-block;
        position: relative;
        top: -2px;
      }
      &:hover{
        color: #ff6700;
        background: #fff;
        i{
          background-image: url('/static/img/cart_hover.png');
        }
      }
    }
  }
}
</style>
