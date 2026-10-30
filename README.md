# SpringBoot 用户管理后端项目
> 基于SpringBoot + MyBatis + MySQL + JWT + BCrypt 实现的简易用户管理后端练手项目

## 项目功能
- 用户注册：新增用户，密码使用BCrypt单向加密存入数据库
- 用户登录：JWT令牌签发，接口鉴权拦截
- 用户CRUD：修改用户、逻辑删除用户、分页查询用户
- 全局统一返回封装 Result
- 全局异常处理器，统一捕获业务异常
- Knife4j 接口文档，可视化调试所有接口
- 拦截器配置：登录/注册接口放行，其余接口需携带Token访问

## 技术栈
- 后端框架：SpringBoot 2.x/3.x
- ORM框架：MyBatis
- 数据库：MySQL8.0
- 鉴权：JWT
- 密码加密：BCrypt
- 分页：PageHelper
- 接口文档：Knife4j(Swagger)
- 构建工具：Maven
## 接口说明
-POST /user/add 新增用户
-POST /user/login 用户登录，放回JWT
-put /user/update 修改用户信息（需token)
-DELETE /user/delete/{id} 逻辑删除用户（需token）
-GET /user/page 用户分页查询
## 后续待完善功能
-Redis实现JWT黑名单，支持主动退出登录
-角色权限控制（管理员/普通用户）
-文件上传（头像上传)
-密码重置功能
-参数校验@valid +自定义校验提示
-单元测试
## 总结
本项目是后端入门练手项目，熟悉SpringBoot开发流程，掌握MyBatis操作数据库、JWT身份认证、密码安全加密、全局异常处理等企业开发基础能力。
