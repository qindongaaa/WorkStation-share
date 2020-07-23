<template>
  <div class="account-settings-info-view">
    <a-table :columns="columns" :data-source="data" bordered>
      <a slot="name" slot-scope="text">{{ text }}</a>
    </a-table>
  </div>
</template>

<script>
import { mapActions } from 'vuex'
import { notification } from 'ant-design-vue'

export default {
  name: 'Weekly',
  data () {
    return {
      data,
      columns
    }
  },
  computed: {
    userInfo () {
      return this.$store.getters.userInfo
    }
  },
  created () {
    this.user = this.userInfo
  },
  mounted () {
    this.getTableInfo()
  },
  methods: {
    ...mapActions(['GetProgramInfoByMag']),
    getTableInfo () {
      const {
        GetProgramInfoByMag
      } = this
      var user = this.user
      const programParams = {
        username: user.name
      }
      GetProgramInfoByMag(programParams)
        .then((res) => {
          console.log(res)
          if (res.result.state === 1) {
            this.data = res.result.object
          } else {
            console.log('创建失败！该项目已存在！')
            var config = {
              message: '创建失败！该项目已存在！'
            }
            notification.error(config)
          }
        })
    }
  }
}
const columns = [
  {
    title: '项目名称',
    dataIndex: 'programname',
    scopedSlots: { customRender: 'name' }
  },
  {
    title: '项目简介',
    dataIndex: 'programbrief',
    ellipsis: true
  },
  {
    title: '合同额',
    dataIndex: 'programquota'
  },
  {
    title: '项目经理',
    dataIndex: 'programmag'
  },
  {
    title: '项目周期',
    dataIndex: 'programduration'
  },
  {
    title: '项目开始时间',
    dataIndex: 'programstarttime'
  }
]
const data = []

</script>
<style lang="less" scoped>

  .avatar-upload-wrapper {
    height: 200px;
    width: 100%;
  }

  .ant-upload-preview {
    position: relative;
    margin: 0 auto;
    width: 100%;
    max-width: 180px;
    border-radius: 50%;
    box-shadow: 0 0 4px #ccc;

    .upload-icon {
      position: absolute;
      top: 0;
      right: 10px;
      font-size: 1.4rem;
      padding: 0.5rem;
      background: rgba(222, 221, 221, 0.7);
      border-radius: 50%;
      border: 1px solid rgba(0, 0, 0, 0.2);
    }
    .mask {
      opacity: 0;
      position: absolute;
      background: rgba(0,0,0,0.4);
      cursor: pointer;
      transition: opacity 0.4s;

      &:hover {
        opacity: 1;
      }

      i {
        font-size: 2rem;
        position: absolute;
        top: 50%;
        left: 50%;
        margin-left: -1rem;
        margin-top: -1rem;
        color: #d6d6d6;
      }
    }

    img, .mask {
      width: 100%;
      max-width: 180px;
      height: 100%;
      border-radius: 50%;
      overflow: hidden;
    }
  }
</style>
