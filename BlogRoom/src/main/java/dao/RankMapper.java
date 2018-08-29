package dao;

import entity.Rank;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RankMapper{
    Rank selectOneByRid(@Param("rid") Integer rid);

    int deleteByRid(@Param("randId") Integer rankId);

    int insertOne(Rank rank);

    int updateByRank(Rank rank);
}