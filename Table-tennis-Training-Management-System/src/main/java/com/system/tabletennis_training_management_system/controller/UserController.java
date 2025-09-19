package com.system.tabletennis_training_management_system.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.system.tabletennis_training_management_system.common.QueryPageParam;
import com.system.tabletennis_training_management_system.pojo.ResponseMessage;
import com.system.tabletennis_training_management_system.pojo.User;
import com.system.tabletennis_training_management_system.pojo.dto.UserDto;
import com.system.tabletennis_training_management_system.service.IUserService;
import com.system.tabletennis_training_management_system.service.UserService;
import com.system.tabletennis_training_management_system.service.impl.UserServiceImpl;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public String test() {
        return "success";
    }

    @Autowired
    IUserService userService;

    @GetMapping("/list")
    public List<User> list() {
        return userService.listAll();
    }

    // 增加
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseMessage<User> add(@Validated @RequestBody UserDto userDto) {
        System.out.println("收到的 UserDto = " + userDto); // 应该能看到非 null 的字段
        User userNew = userService.add(userDto);
        return ResponseMessage.success(userNew);
    }

    // 查询
    @GetMapping("/{userId}")
    public ResponseMessage<User> get(@PathVariable("userId") Integer userId) {
        User userNew = userService.getUser(userId);
        return ResponseMessage.success(userNew);
    }

    // 修改
    @PutMapping("/mod")
    public ResponseMessage<User> edit(@Validated @RequestBody UserDto userDto) {
        User userNew = userService.edit(userDto);
        return ResponseMessage.success(userNew);
    }

    // 删除
    @DeleteMapping("/delete/{userId}")
    public ResponseMessage<User> delete(@PathVariable("userId") Integer userId) {
        userService.delete(userId);
        return ResponseMessage.success(null);
    }

    // 模糊查询
    @PostMapping("/listP")
    public List<User> listP(@RequestBody User user) {
        System.out.println("接收到的userName参数：" + user.getUserName());
        return userService.listP(user.getUserName());
    }

    //分页
    @PostMapping("/listPage")
    public List<User> listPage(@RequestBody QueryPageParam query){
        System.out.println(query);

        System.out.println("num===" + query.getPageNum());
        System.out.println("size===" + query.getPageSize());

        HashMap param = query.getParam() ;
        System.out.println("name===" + (String)param.get("userName"));
        System.out.println("no===" + (String) param.get("no"));

        return null;
    }

}
