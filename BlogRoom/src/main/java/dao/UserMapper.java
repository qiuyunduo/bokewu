package dao;

import entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int insertOne(User user);

    List<User> selectAll();

    List<User> selectFashionUser();

    User selectByNamePwd(@Param("name") String name,@Param("pwd") String pwd);

    User selectAdmin(@Param("name") String name,@Param("pwd") String pwd);

    User selectByName(@Param("name")String name);
    User selectByName1(@Param("name")String name,@Param("id")Integer id);

    User selectById(Integer userId);

    int deleteById(Integer userId);

    int updateBySelective(User user);
}