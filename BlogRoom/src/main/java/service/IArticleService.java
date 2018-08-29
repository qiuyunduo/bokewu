package service;

import entity.Article;

import java.util.List;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 上午10:22 18-8-21
 * @Modified: null
 */
public interface IArticleService {
    int insertOne(Article article);
    List<Article> selectAll();
    List<Article> searchSome(String title);
    List<Article> selectFashionArticle();
    //获得所有未审核通过的文章
    List<Article> selectAllUnchecked();
    //获得所有已审核通过的文章
    List<Article> selectAllChecked();
    //获得一个用户的所有已经审核通过的文章
    List<Article> selectAllCheckedByUserid(Integer userid);
    //获得一个用户的所有正在审核通过的文章
    List<Article> selectAllUncheckByUserid(Integer userid);
    //获得属于一个用户的所有文章
    List<Article> selectAllOfUserid(Integer userid);
    List<Article> selectAllByClassid(Integer classid);
    Integer selectCommentsOfUser(Integer userid);
    Integer selectlikesOfUser(Integer userid);
    Article selectOneById(Long aid);
    int deleteOneByAid(Long aid);
    int updateOneBySelective(Article article);
    int updateCommentsBySelective(Article article);
}
