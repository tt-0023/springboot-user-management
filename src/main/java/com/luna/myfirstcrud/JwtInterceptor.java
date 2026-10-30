//JWT拦截器
package com.luna.myfirstcrud;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;

public class JwtInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截器执行，访问路径："+request.getRequestURI());
        String token=request.getHeader("token");//从请求头获取token，约定key名字叫token
        //验证token
        if(token==null || !JwtUti.validateToken(token)){
            response.setContentType("application/json; charset=utf-8");
            response.getWriter().write("{\"code\":401,\"message\":\"未登录或登录已过期\"}");
            return false;
        }
        //从token中获取用户id
        Long userId=JwtUti.getUserId(token);
        request.setAttribute("userId",userId);
        return true;
    }


}
