import axios from 'axios'
let GET = function (url, successCallback, errorCallback) {
    axios.get(url).then((response) => {
      if (typeof successCallback === 'function') {
        successCallback(response);
      }
    }).catch(response => {
      if (typeof errorCallback === 'function') {
        errorCallback(response);
      }
    })
}
let POST = function (url, data, successCallback, errorCallback) {
  axios.post(url, data).then((response) => {
    if (typeof successCallback === 'function') {
      successCallback(response);
    }
  }).catch(response => {
    if (typeof errorCallback === 'function') {
      errorCallback(response);
    }
  })
}
export default {
    GET,
    POST
}
