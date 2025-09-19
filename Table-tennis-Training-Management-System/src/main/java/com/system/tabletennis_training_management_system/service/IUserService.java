package com.system.tabletennis_training_management_system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.system.tabletennis_training_management_system.pojo.User;
import com.system.tabletennis_training_management_system.pojo.dto.UserDto;

import java.util.HashMap;
import java.util.List;

public interface IUserService extends IService<User> {
    User add(UserDto user);
    User getUser(Integer userId);
    User edit(UserDto user);
    void delete(Integer userId);

    List<User> listAll();
    List<User> listP(String userName);
    IPage<User>listPageByParams(IPage<com.system.tabletennis_training_management_system.pojo.User> page, HashMap<String, Object> params);
}
