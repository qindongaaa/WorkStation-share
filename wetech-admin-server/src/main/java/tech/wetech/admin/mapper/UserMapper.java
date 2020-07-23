package tech.wetech.admin.mapper;

import tech.wetech.admin.model.entity.User;
import tech.wetech.mybatis.mapper.BaseMapper;

public interface UserMapper extends BaseMapper<User> {

    /**
     * 通过用户名获取单个用户
     * @param username
     * @return
     */
    default User selectByUsername(String username) {
        return this.createCriteria().andEqualTo(User::getUsername, username).selectOne();
    }
    /**
     * 通过邮箱获取单个用户
     * @param email
     * @return
     */
    default User selectByEmail(String email) {
        return this.createCriteria().andEqualTo(User::getEmail, email).selectOne();
    }
}
