package io.zbc.learning.spring.data.redis.dao;


import io.zbc.learning.spring.data.redis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface IUserDao {

    @Select("SELECT * FROM user WHERE user_name = #{userName}")
    User selectUserByName(String userName);

}
