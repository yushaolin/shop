<template>
    <Modal  :value="show" :width="modalConfig.width" :mask-closable='false' @on-cancel='cancel' class-name="vertical-center-modal login-area">
        <div slot="header" class="header">
            <span class="title">{{type ? '用户注册' : '用户登陆'}}</span>
        </div>
        <div class="main">
            <div class="form-item">
                <i-input v-model="userSchema.username" placeholder="请输入用户名"></i-input>
            </div>
            <div class="form-item">
                <i-input v-model="userSchema.password" placeholder="请输入密码"></i-input>
            </div>
            <div class="form-item" v-show="type">
                <i-input v-model="userSchema.error_password" placeholder="请再次输入密码"></i-input>
            </div>
        </div>
        <div slot="footer" class="footer">
            <div class="btm-group">
                <button @click="commit(type)">{{type ? '注册' : '登陆'}}</button>
            </div>
        </div>
    </Modal>
</template>
<script>
    import getApiInfo from '@/assets/js/apiInformation'
    // import { drag } from '@/assets/js/util'
    export default{
        name: 'login',
        props: {
            show: {
                type: Boolean
            },
            modalConfig: {
                type: Object,
                require: false
            },
            cancel: {
                type: Function,
                require: true
            },
            type: {
                type: Number,
                require: true
            }
        },
        data() {
            return {
                userSchema: getApiInfo('userInfo')
            }
        },
        methods: {
        },
        watch: {
            show(now) {
                if (now) {
                    // this.$nextTick(() => {
                    //     let panel = document.querySelector('.ivu-modal');
                    //     let head = document.querySelector('.ivu-modal-header');
                    //     drag(head, panel);
                    // });
                }
            }
        }
    }
</script>
<style scoped lang="scss">
.main{
    .form-item{
        margin-bottom: 20px;
    }
}
.footer{
    text-align: center;
    .btm-group{
        button{
            width: 100%;
            height: 50px;
            line-height: 50px;
            color: white;
            background-color: #ef5b00;
            border: none;
            font-size: 18px;
            cursor: pointer;
        }
        margin-bottom:14px;
    }
}
</style>


