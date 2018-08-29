package service;

import entity.Rank;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午9:11 18-8-24
 * @Modified: null
 */
public interface IRankService {
    Rank selectOneByRid(Integer rid);

    int deleteByRid(Integer rankId);

    int insertOne(Rank rank);

    int updateByRank(Rank rank);
}
