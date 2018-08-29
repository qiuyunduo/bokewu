package dao;

import entity.Attention;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AttentionMapper {

    int deleteBySelective(Attention attention);

    int insertOne(Attention attention);

    //查询某一用户所有关注的用户（关注）
    List<Integer> selectAllOfGid(@Param("Gid")Integer Gid);
    //查询所有关注了某一用户的用户（粉丝）
    List<Integer> selectAllOfFid(@Param("Fid")Integer Fid);

}