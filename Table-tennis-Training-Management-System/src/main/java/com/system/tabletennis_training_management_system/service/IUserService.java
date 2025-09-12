package com.system.tabletennis_training_management_system.service;

import com.system.tabletennis_training_management_system.pojo.User;
import com.system.tabletennis_training_management_system.pojo.dto.UserDto;

public interface IUserService {
    User add(UserDto user);
    User getUser(Integer userId);
    User edit(UserDto user);
    void delete(Integer userId);
}
