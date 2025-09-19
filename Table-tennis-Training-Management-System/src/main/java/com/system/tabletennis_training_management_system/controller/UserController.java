package com.system.tabletennis_training_management_system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.system.tabletennis_training_management_system.common.QueryPageParam;
import com.system.tabletennis_training_management_system.common.Result;
import com.system.tabletennis_training_management_system.pojo.ResponseMessage;
import com.system.tabletennis_training_management_system.pojo.User;
import com.system.tabletennis_training_management_system.pojo.dto.UserDto;
import com.system.tabletennis_training_management_system.service.IUserService;
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

        Integer pageNum = query.getPageNum();
        Integer pageSize = query.getPageSize();
        System.out.println("num===" + pageNum);
        System.out.println("size===" + pageSize);

        HashMap param = query.getParam() ;
        String userName = (String)param.get("userName");
        System.out.println("name===" + (String)param.get("userName"));
        String no = (String)param.get("userNo");
        System.out.println("no===" + (String) param.get("no"));

        Page<User> page = new Page<>(pageNum, pageSize);
        IPage<User> result = userService.listPageByParams(page, query.getParam());
        System.out.println("total===" + result.getTotal());

        return result.getRecords();
    }

    @PostMapping("/msg")
    public Result listmsg(@RequestBody QueryPageParam query){
        System.out.println(query);

        Integer pageNum = query.getPageNum();
        Integer pageSize = query.getPageSize();
        System.out.println("num===" + pageNum);
        System.out.println("size===" + pageSize);

        HashMap param = query.getParam() ;
        String userName = (String)param.get("userName");
        System.out.println("name===" + (String)param.get("userName"));
        String no = (String)param.get("userNo");
        System.out.println("no===" + (String) param.get("no"));

        Page<User> page = new Page<>(pageNum, pageSize);
        IPage<User> result = userService.listPageByParams(page, query.getParam());
        System.out.println("total===" + result.getTotal());

        return Result.success(result.getRecords(),result.getTotal());
    }

}
