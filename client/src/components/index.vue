<template>
  <div class="main">
    <app-head></app-head>
    <app-search></app-search>
    <div class="site-category container flex">
      <ul class="site-category-list">
        <li class="category-item">
          <a href="#">手机电话卡<i class="icon"></i></a>
        </li>
        <li class="category-item">
          <a href="#">电视盒子<i class="icon"></i></a>
        </li>
        <li class="category-item">
          <a href="#">笔记本平板<i class="icon"></i></a>
        </li>
        <li class="category-item">
          <a href="#">家电插线板<i class="icon"></i></a>
        </li>
        <li class="category-item">
          <a href="#">出行穿戴<i class="icon"></i></a>
        </li>
        <li class="category-item">
          <a href="#">智能路由器<i class="icon"></i></a>
        </li>
        <li class="category-item">
          <a href="#">电源配件<i class="icon"></i></a>
        </li>
        <li class="category-item">
          <a href="#">个护儿童<i class="icon"></i></a>
        </li>
        <li class="category-item">
          <a href="#">耳机音响<i class="icon"></i></a>
        </li>
        <li class="category-item">
          <a href="#">生活箱包<i class="icon"></i></a>
        </li>
      </ul>
      <div class="banner">
        <Carousel autoplay>
          <CarouselItem>
            <div class="carousel-item">
              <a href="#"><img src="/static/img/banner/banner1.jpg"></a>
            </div>
          </CarouselItem>
          <CarouselItem>
            <div class="carousel-item">
              <a href="#"><img src="/static/img/banner/banner1.jpg"></a>
            </div>
          </CarouselItem>
          <CarouselItem>
            <div class="carousel-item">
              <a href="#"><img src="/static/img/banner/banner1.jpg"></a>
            </div>
          </CarouselItem>
        </Carousel>
      </div>
    </div>
  </div>
</template>

<script>
import search from '@/components/common/search.vue'
export default {
  name: 'index',
  components: {
    'app-search': search
  },
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
.main{
  font: 14px/1.5 "Helvetica Neue",Helvetica,Arial,"Microsoft Yahei","Hiragino Sans GB","Heiti SC","WenQuanYi Micro Hei",sans-serif;
  color: #333;
  background-color: #fff;
  min-width: 1226px;
}
.site-category{
  position: relative;
  height: 460px;
  .site-category-list{
    position: absolute;
    height: 460px;
    width: 234px;
    background-color: rgba(0,0,0,0.6);
    padding: 20px 0;
    left:0;
    top:0;
    z-index: 10;
    li.category-item{
      a{
        color: white;
        display: block;
        padding-left: 30px;
        height: 42px;
        line-height: 42px;
        font-size: 16px;
        i{
          background-image: url('/static/img/to_left.png');
          background-size: 16px 16px;
          display: inline-block;
          width:16px;
          height: 16px;
          float: right;
          margin-top: 13px;
          margin-right: 30px;
        }
        &:hover{
          background-color: #ff6700;
        }
      }

    }
  }
  .banner{
    .carousel-item{
      img {
        height: 460px;
      }
    }
  }
}
</style>
