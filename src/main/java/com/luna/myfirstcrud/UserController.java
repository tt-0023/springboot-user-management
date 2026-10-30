package com.luna.myfirstcrud;

import com.luna.myfirstcrud.entity.Users;
import com.github.pagehelper.PageInfo;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;;
@RestController
@RequestMapping("/user")

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String test(){
        return "Controller 访问成功！";
    }
    @GetMapping("/{id}")
    public Result<Users> getUserById(@PathVariable int id) {
        Users user = userService.selectUserById(id);
        return user != null ? Result.success(user) : Result.error(null);
    }

    @GetMapping("/page")
    public Result<PageInfo<Users>> getUserByPage(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize) {
        return Result.success(userService.getUserByPage(pageNum, pageSize));
    }

    @PostMapping("/add")
    @Operation(summary = "新增用户")
    public Result<String> addUser(@Valid @RequestBody Users user) {
        int rows = userService.addUser(user);
        return rows > 0 ? Result.success("新增成功") : Result.error("新增失败");
    }

    @PutMapping("/update")
    public Result<String> updateUser(@RequestBody Users user) {
        int rows = userService.updateUser(user);
        return rows > 0 ? Result.success("修改成功") : Result.error("修改失败");
    }

    @DeleteMapping("/delete/{id}")
    public Result<String> deleteUser(@PathVariable int id) {
        int rows = userService.deleteUser(id);
        return rows > 0 ? Result.success("删除成功") : Result.error("删除失败");
    }
    //login 接口
    @PostMapping("/login")
    @Operation(summary = "用户登录,返回JWT令牌")
    public Result<String> login(@Valid@RequestBody loginDTO loginDTO) {
        String token = userService.login(loginDTO);
        return token != null ? Result.success(token) : Result.error("登录失败");
    }

}
