package service.impl;

import dao.ArticleClassMapper;
import entity.ArticleClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.IArticleClassService;

import java.util.List;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午9:31 18-8-24
 * @Modified: null
 */
@Service("articleClassService")
public class ArticleClassServiceImpl implements IArticleClassService {
    @Autowired
    private ArticleClassMapper articleClassMapper;

    @Override
    public int deleteByAcid(Integer articleClassId) {
        return articleClassMapper.deleteByAcid(articleClassId);
    }

    @Override
    public int insertOne(ArticleClass articleClass) {
        return articleClassMapper.insertOne(articleClass);
    }

    @Override
    public List<ArticleClass> selectAllByPid(Integer pid) {
        return articleClassMapper.selectAllByPid(pid);
    }

    @Override
    public int updateBySelective(ArticleClass articleClass) {
        return articleClassMapper.updateBySelective(articleClass);
    }
}
