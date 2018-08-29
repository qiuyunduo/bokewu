package service;

import entity.Attention;

import java.util.List;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午9:11 18-8-24
 * @Modified: null
 */
public interface IAttentionService {
    int deleteBySelective(Attention attention);

    int insertOne(Attention attention);

    //查询某一用户所有关注的用户（关注）
    List<Integer> selectAllOfGid(Integer Gid);
    //查询所有关注了某一用户的用户（粉丝）
    List<Integer> selectAllOfFid(Integer Fid);
}
