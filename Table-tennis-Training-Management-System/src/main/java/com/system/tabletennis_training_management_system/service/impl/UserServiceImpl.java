package com.system.tabletennis_training_management_system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.system.tabletennis_training_management_system.mapper.UserMapper;
import com.system.tabletennis_training_management_system.pojo.User;
import com.system.tabletennis_training_management_system.pojo.dto.UserDto;
import com.system.tabletennis_training_management_system.repository.UserRepository;
import com.system.tabletennis_training_management_system.service.IUserService;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

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

    @Resource
    private UserMapper userMapper;
    @Override
    public List<User> listAll() {
        return userMapper.listAll();
    }

    @Override
    public List<User> listP(String userName) {
        return userMapper.findByUserNameLike(userName);
    }

    public IPage<User> listPageByParams(IPage<User> page, HashMap<String, Object> params) {
        // 从参数中获取 userName
        String userName = (String) params.get("userName");

        // 获取分页参数
        long pageNum = page.getCurrent();
        long pageSize = page.getSize();
        int offset = (int) ((pageNum - 1) * pageSize);

        // 1. 查询总记录数
        Long total = userMapper.countUsers(userName);

        // 2. 查询当前页数据
        List<User> records = userMapper.listPage(offset, (int) pageSize, userName);

        // 3. 手动封装成 IPage 对象
        IPage<User> resultPage = new Page<>(pageNum, pageSize, total);
        resultPage.setRecords(records);

        return resultPage;
    }
}
