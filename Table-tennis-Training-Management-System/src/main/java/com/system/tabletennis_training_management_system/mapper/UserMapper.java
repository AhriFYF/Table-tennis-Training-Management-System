package com.system.tabletennis_training_management_system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.system.tabletennis_training_management_system.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    List<User> listAll();
    List<User> findByUserNameLike(@Param("userName") String userName);

    // 自定义分页查询方法
    // @Param("page") 必须指定，用于在XML中引用MyBatis-Plus的分页对象
    // @Param("userName") 用于传递模糊查询参数
    IPage<User> listPageByParams(IPage<User> page, @Param("userName") String userName);

    // 查询总记录数
    Long countUsers(@Param("userName") String userName);

    // 查询当前页的数据，使用 offset 和 limit
    List<User> listPage(@Param("offset") int offset, @Param("pageSize") int pageSize, @Param("userName") String userName);
}
