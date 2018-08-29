package dao;

import entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {

    int deleteByCid(@Param("commentId") Long commentId);

    int insertOne(Comment comment);

    Comment selectOneByCid(@Param("commentId")Long commentId);

    List<Comment> selectAllByAid(@Param("aid")Long aid);

    int updateByComment(Comment comment);

}