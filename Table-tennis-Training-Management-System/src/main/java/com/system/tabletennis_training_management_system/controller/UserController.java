package com.system.tabletennis_training_management_system.controller;

import com.system.tabletennis_training_management_system.pojo.ResponseMessage;
import com.system.tabletennis_training_management_system.pojo.User;
import com.system.tabletennis_training_management_system.pojo.dto.UserDto;
import com.system.tabletennis_training_management_system.service.IUserService;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public List<User> list(){
        return userService.list();
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
    @PutMapping
    public ResponseMessage<User> edit(@Validated @RequestBody UserDto userDto) {
        User userNew = userService.edit(userDto);
        return ResponseMessage.success(userNew);
    }
    // 删除
    @DeleteMapping("/{userId}")
    public ResponseMessage<User> delete(@PathVariable("userId") Integer userId) {
        userService.delete(userId);
        return ResponseMessage.success(null);
    }
}
