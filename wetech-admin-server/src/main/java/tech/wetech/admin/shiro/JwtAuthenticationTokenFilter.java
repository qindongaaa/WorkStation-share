package tech.wetech.admin.shiro;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ThreadContext;
import org.apache.shiro.web.subject.WebSubject;
import org.apache.shiro.web.subject.WebSubject.Builder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;
import tech.wetech.admin.model.entity.User;
import tech.wetech.admin.service.UserService;


/**
 * 过滤请求头部信息，如果有，就自动登录
 * http://blog.csdn.net/qi923701/article/details/75007813
 * @author wutao
 * @date    2017年11月11日 下午3:09:51
 */
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationTokenFilter.class);

    @Autowired
    private UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
        throws ServletException, IOException {
        String tokenHeader = request.getHeader("Access-Token");//从头部获取JWT字符串信息
        if(logger.isDebugEnabled()) {
            logger.debug("=========>tokenHeader {}", tokenHeader);
        }
        if(StringUtils.isNotBlank(tokenHeader)) {
            String username = JwtUtil.getUserIdFromToken(tokenHeader);//解码JWT，获得username
            if(username!=null) {
                if (logger.isDebugEnabled()) {
                    logger.debug("getUserIdFromToken username {}", username);
                }

                User auser=userService.queryByUsername(username);//根据userID获取用户信息
                if(auser!=null) {
                    PrincipalCollection principals = new SimplePrincipalCollection(auser, "authorizingRealm");//拼装shiro用户信息
                    Builder builder = new WebSubject.Builder(request, response);
                    builder.principals(principals);
                    builder.authenticated(true);
                    WebSubject subject = builder.buildWebSubject();
                    ThreadContext.bind(subject);//塞入容器，统一调用
                }

            }
        }
        chain.doFilter(request, response);
    }

}
