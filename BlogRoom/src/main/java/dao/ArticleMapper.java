package dao;

import entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleMapper {

    List<Article> selectAll();

    List<Article> searchSome(@Param("title")String title);
    List<Article> selectFashionArticle();
    //获得所有未审核通过的文章
    List<Article> selectAllUnchecked();
    //获得所有已审核通过的文章
    List<Article> selectAllChecked();
    //获得一个用户的所有已经审核通过的文章
    List<Article> selectAllCheckedByUserid(@Param("userid") Integer userid);
    //获得一个用户的所有正在审核通过的文章
    List<Article> selectAllUncheckByUserid(@Param("userid") Integer userid);
    //获得属于一个用户的所有文章
    List<Article> selectAllOfUserid(@Param("userid") Integer userid);
    List<Article> selectAllByClassid(@Param("classid") Integer classid);
    Article selectOneById(@Param("aid")Long aid);
    Integer selectCommentsOfUser(@Param("userid")Integer userid);
    Integer selectlikesOfUser(@Param("userid")Integer userid);
    int insertOne(Article article);
    int deleteOneByAid(@Param("aid")Long aid);
    int updateOneBySelective(Article article);


}