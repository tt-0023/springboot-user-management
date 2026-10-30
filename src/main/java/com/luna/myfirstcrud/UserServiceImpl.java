package com.luna.myfirstcrud;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.luna.myfirstcrud.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, Users> implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public Users selectUserById(int id) {
        return userMapper.selectUserById(id);
    }
    @Override
    public PageInfo<Users> getUserByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(userMapper.getUserByPage());
    }
    @Override
    public int addUser(Users user) {
        user.setPassword(PasswordUtil.encode(user.getPassword()));
        if(user.getAge()<0) return -1;
        return userMapper.insertUser(user);
    }

    @Override
    public int updateUser(Users user) {
        return userMapper.updateUser(user);
    }
    @Override
    public int deleteUser(int id) {
        return userMapper.deleteUser(id);
    }
    @Override
    public String login(loginDTO loginDTO) {
        //根据用户名查询数据库用户
        Users user = userMapper.selectUserByName(loginDTO.getUsername());
        if(user==null){
            throw new BusinessException("用户不存在");
        }
        Boolean ok = PasswordUtil.matches(loginDTO.getPassword(), user.getPassword());
        if(ok){
            return JwtUti.generateToken(user.getId());
        }else{
            return null;
        }
    }
}
