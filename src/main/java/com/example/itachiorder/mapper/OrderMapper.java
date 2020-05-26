package com.example.itachiorder.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface OrderMapper {
    @Insert("insert into orders(user_id,count) values (#{user_id},#{count})")
    void addTheOrder(@Param("user_id") String userId, @Param("count") int count);
}
