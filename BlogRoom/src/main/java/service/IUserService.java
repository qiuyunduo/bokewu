package service;

import entity.User;

import java.util.List;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午7:24 18-8-13
 * @Modified: null
 */
public interface IUserService {
    int insertOne(User user);

    List<User> selectAll();

    List<User> selectFashionUser();

    User selectByNamePwd(String name,String pwd);

    User selectAdmin(String name,String pwd);

    User selectById(Integer userId);

    int deleteById(Integer userId);

    int updateBySelectiveImg(User user);

    int updateBySelectiveInfo(User user);

    int updateBySelectivePwd(User user);

    int updateBySelectiveMark(User user);
}
