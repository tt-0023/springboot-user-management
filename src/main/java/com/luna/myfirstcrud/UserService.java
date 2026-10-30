package com.luna.myfirstcrud;
import com.luna.myfirstcrud.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
public interface UserService extends IService<Users> {
    Users selectUserById(int id);
    PageInfo<Users> getUserByPage(int pageNum, int pageSize);
    int addUser(Users user);
    int updateUser(Users user);

    int deleteUser(int id);

    String login(loginDTO loginDTO);
}
