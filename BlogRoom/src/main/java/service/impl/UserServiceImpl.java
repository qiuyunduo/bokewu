package service.impl;

import dao.UserMapper;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.IUserService;

import java.util.List;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午4:47 18-8-21
 * @Modified: null
 */
@Service(value = "userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int insertOne(User user) {
        String name = user.getUserName();
        if(userMapper.selectByName(name) != null){
            return 2;
        }
        return userMapper.insertOne(user);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public List<User> selectFashionUser() {
        return userMapper.selectFashionUser();
    }

    @Override
    public User selectByNamePwd(String name, String pwd) {
        return userMapper.selectByNamePwd(name,pwd);
    }

    @Override
    public User selectAdmin(String name, String pwd) {
        return userMapper.selectAdmin(name,pwd);
    }

    @Override
    public User selectById(Integer userId) {
        return userMapper.selectById(userId);
    }

    @Override
    public int deleteById(Integer userId) {
        return userMapper.deleteById(userId);
    }

    @Override
    public int updateBySelectiveImg(User user) {
        return userMapper.updateBySelective(user);
    }

    @Override
    public int updateBySelectiveInfo(User user) {
        String name = user.getUserName();
        Integer id = user.getUserId();
        if(userMapper.selectByName1(name,id) != null){
            return 2;
        }
        return userMapper.updateBySelective(user);
    }

    @Override
    public int updateBySelectivePwd(User user) {
        return userMapper.updateBySelective(user);
    }

    @Override
    public int updateBySelectiveMark(User user) {
        return userMapper.updateBySelective(user);
    }
}
