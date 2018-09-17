import { deepCopy } from './util'
const information = {
    userInfo: {
        userName: '',
        password: '',
        error_password: '',
        VerificationCode: ''
    }
}
function getInfo(params) {
    return deepCopy(information[params]);
}
export default getInfo;
