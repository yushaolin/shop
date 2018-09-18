<template>
    <Modal  :value="show" :width="modalConfig.width" :mask-closable='false' @on-cancel='cancel' class-name="vertical-center-modal login-area">
        <div slot="header" class="header">
            <span class="title">{{showType ? '用户注册' : '用户登陆'}}</span>
        </div>
        <div class="main">
            <div class="form-item">
                <i-input v-model="userSchema.userName" placeholder="请输入用户名"></i-input>
            </div>
            <div class="form-item">
                <i-input v-model="userSchema.password" placeholder="请输入密码"></i-input>
            </div>
            <div class="form-item" v-show="showType">
                <i-input v-model="userSchema.error_password" placeholder="请再次输入密码"></i-input>
            </div>
            <div class="form-item verification-wrap flex">
                <i-input v-model="userSchema.VerificationCode" placeholder="请输入验证码"></i-input>
                <img :src="verificationUrl" class="verification" @click="getVerfiction">
            </div>
            <div class="form-item">
                <div class="other-panel" v-show="!showType">
                    <span class="registe-btn link" @click="changeStatus(true)">立即注册</span>
                </div>
                <div class="other-panel" v-show="showType">
                    <span class="login-btn link" @click="changeStatus(false)">立即登陆</span>
                </div>
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
    import resutlUtil from '@/assets/js/resultUtil'
    import apiUrl from '@/assets/js/apiUrl'
    import { stringify } from '@/assets/js/util'
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
                userSchema: getApiInfo('userInfo'),
                showType: this.show,
                verificationUrl: apiUrl.userInfo.verification
            }
        },
        methods: {
            changeStatus(type) {
                this.showType = type;
            },
            /**
             * @param type 0：登陆 1:注册
             */
            commit(type) {
                let url = apiUrl.userInfo.login;
                let request = JSON.parse(JSON.stringify(this.userSchema));
                if (!type) {
                    delete request.error_password;
                    request = stringify(request);
                    resutlUtil.POST(url, request, response => {
                        if (response.body.result === 'success' && response.status === 200) {

                        }
                    }, error => {
                        console.warn(error);
                    })
                } else {
                    resutlUtil.POST(url, JSON.stringify(request), response => {
                        console.log(response.data);
                    }, error => {
                        console.warn(error);
                    })
                }
            },
            // 获取验证码
            getVerfiction() {
                let url = apiUrl.userInfo.verification;
                this.verificationUrl = url + '?' + Math.random();
            }
        },
        watch: {
            show(now) {
                if (now) {
                    this.changeStatus(this.type);
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
        .other-panel{
            text-align: right;
            font-size: 14px;
        }
    }
    .verification-wrap{
        justify-content: space-around;
        img{
            width: 150px;
            height: 48px;
        }
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


