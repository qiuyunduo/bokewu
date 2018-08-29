package dao;

import entity.ArticleClass;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleClassMapper {

    int deleteByAcid(@Param("Acid") Integer articleClassId);

    int insertOne(ArticleClass articleClass);


    List<ArticleClass> selectAllByPid(@Param("pid")Integer pid);

    int updateBySelective(ArticleClass articleClass);
}