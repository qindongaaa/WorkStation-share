
import { constantRouterMap } from '@/config/router.config'
import { createProgram, getCurUserPorgramInfo } from '@/api/program'

const program = {
  state: {
    routers: constantRouterMap,
    addRouters: []
  },
  mutations: {
    SET_ROUTERS: (state, routers) => {
      state.addRouters = routers
      state.routers = constantRouterMap.concat(routers)
    }
  },
  actions: {
    CreateProgram ({ commit }, programParams) {
      return new Promise((resolve, reject) => {
        createProgram(programParams).then(response => {
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    GetProgramInfoByMag ({ commit }, programParams) {
      return new Promise((resolve, reject) => {
        getCurUserPorgramInfo(programParams).then(response => {
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    }
  }
}
export default program
