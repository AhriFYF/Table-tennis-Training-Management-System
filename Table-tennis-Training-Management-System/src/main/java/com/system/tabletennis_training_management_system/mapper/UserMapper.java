package com.system.tabletennis_training_management_system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.system.tabletennis_training_management_system.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    List<User> listAll();
    List<User> findByUserNameLike(@Param("userName") String userName);
}
