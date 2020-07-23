//package tech.wetech.admin.utils;
//
//import lombok.Data;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.stereotype.Component;
//import tech.wetech.admin.model.entity.User;
//import tech.wetech.admin.service.UserService;
//
//import javax.annotation.PostConstruct;
//import javax.servlet.http.HttpServletRequest;
//import java.util.Map;
//
//
//
//public class XcOauth2Util {
//
//    public UserJwt getUserJwtFromHeader(HttpServletRequest request){
//        String jwtClaims = Oauth2Util.getJwtClaimsFromHeader(request);
//        if(jwtClaims == null || StringUtils.isEmpty(jwtClaims)){
//            return null;
////        }
////        UserJwt userJwt = new UserJwt();
//        User userinfo = xcOauth2Util.userService.queryByUsername(jwtClaims);
//        if(userinfo != null){
//            userJwt.setId(userinfo.getId());
//            userJwt.setUsername(userinfo.getUsername());
//            userJwt.setEmail(userinfo.getEmail());
//            userJwt.setRoleIds(userinfo.getRoleIds());
//        };
//
//        return userJwt;
//    }
//
//    @Data
//    public static class UserJwt{
//        private Long id;
//        private String username;
//        private String email;
//        private String roleIds;
//
//        public Long getId() {
//            return id;
//        }
//
//        public void setId(Long id) {
//            this.id = id;
//        }
//
//        public String getUsername() {
//            return username;
//        }
//
//        public void setUsername(String username) {
//            this.username = username;
//        }
//
//        public String getEmail() {
//            return email;
//        }
//
//        public void setEmail(String email) {
//            this.email = email;
//        }
//
//        public String getRoleIds() {
//            return roleIds;
//        }
//
//        public void setRoleIds(String roleIds) {
//            this.roleIds = roleIds;
//        }
//
//
//    }
//
//}
