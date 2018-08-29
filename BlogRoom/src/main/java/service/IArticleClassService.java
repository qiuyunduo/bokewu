package service;

import entity.ArticleClass;

import java.util.List;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午9:30 18-8-24
 * @Modified: null
 */
public interface IArticleClassService {
    int deleteByAcid(Integer articleClassId);

    int insertOne(ArticleClass articleClass);


    List<ArticleClass> selectAllByPid(Integer pid);

    int updateBySelective(ArticleClass articleClass);
}
