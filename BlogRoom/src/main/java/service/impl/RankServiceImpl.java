package service.impl;

import dao.RankMapper;
import entity.Rank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.IRankService;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午9:42 18-8-24
 * @Modified: null
 */
@Service("rankService")
public class RankServiceImpl implements IRankService{
    @Autowired
    private RankMapper rankMapper;

    @Override
    public Rank selectOneByRid(Integer rid) {
        return rankMapper.selectOneByRid(rid);
    }

    @Override
    public int deleteByRid(Integer rankId) {
        return rankMapper.deleteByRid(rankId);
    }

    @Override
    public int insertOne(Rank rank) {
        return rankMapper.insertOne(rank);
    }

    @Override
    public int updateByRank(Rank rank) {
        return rankMapper.updateByRank(rank);
    }
}
