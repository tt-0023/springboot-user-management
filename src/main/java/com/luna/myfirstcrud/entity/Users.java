package com.luna.myfirstcrud.entity;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jdk.jfr.DataAmount;
@Schema(description = "用户实体类")

public class Users {
    @Schema(description = "用户ID")
    private Long id;
    @Schema(description = "用户名称")
    @NotBlank(message = "用户名称不能为空")
    private String name;
    @Schema(description = "用户年龄")
    private int age;
    @Schema(description = "用户电话")
    private String phone;
    @Schema(description = "用户密码")
    private String password;
    @Schema(description = "用户逻辑删除标志 0正常1删除")
    @TableLogic
    private Integer deleted;

    public Users() {
    }

    public Users(Long id, String name, int age, String phone, String password) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
