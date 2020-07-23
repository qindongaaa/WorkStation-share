<template>
  <div class="account-settings-info-view">
    <a-row :gutter="16">
      <a-col :md="24" :lg="16">

        <a-form layout="vertical" :form="form" ref="programinfo" id="programinfo">
          <a-form-item
            label="项目名称"
          >
            <a-input placeholder="项目全称或者代称" v-decorator="['programname', {rules: [{ required: true, message: '请输入项目名' }], validateTrigger: ['change', 'blur']}]">
            </a-input>
          </a-form-item>
          <a-form-item
            label="项目简介"
          >
            <a-textarea rows="4" placeholder="简述该项目的背景、意义、规模等" v-decorator="['programbrief', {validateTrigger: ['change', 'blur']}]">
            </a-textarea>
          </a-form-item>

          <a-form-item
            label="项目负责人"
            :required="false"
          >
            <a-input placeholder="项目经理、客户经理等" v-decorator="['programmag', {validateTrigger: ['change', 'blur']}]">
            </a-input>
          </a-form-item>
          <a-form-item
            label="开始时间"
            :required="false"
          >
            <a-date-picker @change="onChange" v-decorator="['programstarttime', {rules: [{ required: true, message: '请输入项目开始时间' }],validateTrigger: ['change', 'blur']}]">
            </a-date-picker>
          </a-form-item>
          <a-form-item
            label="合同额度"
            :required="false"
          >
            <a-input placeholder="单位：元" v-decorator="['programquota', {rules: [{ required: true, message: '请输入项目合同额' }],validateTrigger: ['change', 'blur']}]">
            </a-input>
          </a-form-item>
          <a-form-item
            label="预计工期（天）"
            :required="false"
          >
            <a-input placeholder="以自然日为单位" v-decorator="['programduration', {validateTrigger: ['change', 'blur']}]">
            </a-input>
          </a-form-item>
          <a-form-item>
            <a-button
              size="large"
              type="primary"
              htmlType="submit"
              @click.stop.prevent="handleSubmit">提交</a-button>
          </a-form-item>
        </a-form>
      </a-col>

    </a-row>
  </div>
</template>

<script>
import { notification } from 'ant-design-vue'
import { mapActions } from 'vuex'

export default {
  name: 'Newprogram',
  components: {},
  data () {
    return {
      form: this.$form.createForm(this)
    }
  },
  methods: {
    ...mapActions(['CreateProgram']),
    onChange (date, dateString) {
      console.log(date, dateString)
    },
    handleSubmit () {
      const {
        form: { validateFields },
        CreateProgram
      } = this
      validateFields({ force: true }, (err, values) => {
        if (!err) {
          console.log('form value', values)
          const programParams = { ...values }
          CreateProgram(programParams)
            .then((res) => {
              console.log(res)
              if (res.result.state === 1) {
                var config1 = {
                  message: '创建成功'
                }
                notification.success(config1)
              } else {
                console.log('创建失败！该项目已存在！')
                var config = {
                  message: '创建失败！该项目已存在！'
                }
                notification.error(config)
              }
            })
        } else {
          setTimeout(() => {
            // state.loginBtn = false
          }, 600)
        }
      })
    }
  }
}
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
