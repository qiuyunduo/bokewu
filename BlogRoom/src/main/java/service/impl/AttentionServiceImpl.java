package service.impl;

import dao.AttentionMapper;
import entity.ArticleClass;
import entity.Attention;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.IArticleClassService;
import service.IAttentionService;

import java.util.List;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午9:36 18-8-24
 * @Modified: null
 */
@Service("attentionService")
public class AttentionServiceImpl implements IAttentionService {
    @Autowired
    private AttentionMapper attentionMapper;

    @Override
    public int deleteBySelective(Attention attention) {
        return attentionMapper.deleteBySelective(attention);
    }

    @Override
    public int insertOne(Attention attention) {
        return attentionMapper.insertOne(attention);
    }

    @Override
    public List<Integer> selectAllOfGid(Integer Gid) {
        return attentionMapper.selectAllOfGid(Gid);
    }

    @Override
    public List<Integer> selectAllOfFid(Integer Fid) {
        return attentionMapper.selectAllOfFid(Fid);
    }
}
