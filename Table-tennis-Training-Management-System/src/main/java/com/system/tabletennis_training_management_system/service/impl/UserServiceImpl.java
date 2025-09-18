package com.system.tabletennis_training_management_system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.system.tabletennis_training_management_system.mapper.UserMapper;
import com.system.tabletennis_training_management_system.pojo.User;
import com.system.tabletennis_training_management_system.pojo.dto.UserDto;
import com.system.tabletennis_training_management_system.repository.UserRepository;
import com.system.tabletennis_training_management_system.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User add(UserDto user) {
        User userPojo = new User();
        BeanUtils.copyProperties(user, userPojo);
        return userRepository.save(userPojo);
    }

    @Override
    public User getUser(Integer userId) {
        return userRepository.findById(userId).orElseThrow( () -> {throw new IllegalArgumentException("User not found");} );
    }

    @Override
    public User edit(UserDto user) {
        User userPojo = new User();
        BeanUtils.copyProperties(user, userPojo);
        return userRepository.save(userPojo);
    }

    @Override
    public void delete(Integer userId) {
        userRepository.deleteById(userId);
    }

}
