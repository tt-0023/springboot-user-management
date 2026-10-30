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
## 环境依赖
- JDK：17 / JDK 11（根据SpringBoot版本选择）
- Maven：3.6+
- MySQL：8.0
- IDE：IDEA
## 数据库准备
1. 创建数据库（数据库名可自行修改，注意同步yml配置）
create database in not exisits user_management default character set utfmb4 collate utf8mb4_general_ci
2.创建用户表
CREATE TABLE 'user' (
'id' bigint primary key auto_increment comment '主键ID',
'username' varchar(50) not null comment '用户名'
'password' varchar(100) not null comment 'BCrypt加密后的密码'
'deleted' tinyint default 0 comment '逻辑删除标识：0未删除，1已删除'
'create_time' datetime default current_timestamp comment '创建时间'
'update_time'  datetime default curent_timestamp on update current_itmestamp comment '更新时间'
3.修改配置文件
spring:
  datasource:
    url: jdbc:mysql://127.0.0.1:3306/user_management?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai
    username: root
    password:
##  启动项目
1. IDEA导入项目，等待Maven依赖下载完成
​2. 找到项目启动类，右键运行
​3. 项目启动成功后，访问 Knife4j 接口文档地址：http://127.0.0.1:8080/doc.html
## 接口测试流程
1. 调用  /user/add  注册用户（密码会自动BCrypt加密存入数据库）
2. 调用  /user/login  获取 JWT Token
3. 在Knife4j页面配置全局Token，之后即可调用需要鉴权的接口（修改、删除、分页查询）
