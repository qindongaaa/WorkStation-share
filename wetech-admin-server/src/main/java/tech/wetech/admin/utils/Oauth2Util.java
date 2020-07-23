package tech.wetech.admin.utils;

import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import com.auth0.jwt.JWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.admin.model.entity.User;
import tech.wetech.admin.service.UserService;
import tech.wetech.admin.shiro.JwtUtil;
import javax.servlet.http.HttpServletRequest;
import static tech.wetech.admin.shiro.JwtUtil.getClaim;

public class Oauth2Util {

    public static String getJwtClaimsFromHeader(HttpServletRequest request) {
        if (request == null) {
            return null;
        }
        //取出头信息
        String authorization = request.getHeader("Access-Token");
        if (StringUtils.isEmpty(authorization)) {
            return null;
        }
        String message = "";
        try {
            //解析jwt
            DecodedJWT jwt = JWT.decode(authorization);
            //得到 jwt中的用户信息
            message = getClaim(authorization, JwtUtil.ACCOUNT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }
}

