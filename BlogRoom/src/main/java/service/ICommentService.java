package service;

import entity.Comment;

import java.util.List;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午9:11 18-8-24
 * @Modified: null
 */
public interface ICommentService {
    int deleteByCid(Long commentId);

    int insertOne(Comment comment);

    Comment selectOneByCid(Long commentId);

    List<Comment> selectAllByAid(Long aid);

    int updateByComment(Comment comment);
}
