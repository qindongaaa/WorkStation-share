import api from './index'
import { axios } from '@/utils/request'

export function createProgram (parameter) {
  return axios({
    url: api.CreateProgram,
    method: 'post',
    data: parameter
  })
}

export function getCurUserPorgramInfo (parameter) {
  return axios({
    url: api.GetCurUserPorgramInfo,
    method: 'post',
    data: parameter
  })
}
