package service.impl;

import dao.CommentMapper;
import entity.Article;
import entity.Comment;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.IArticleService;
import service.ICommentService;

import java.util.List;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午9:40 18-8-24
 * @Modified: null
 */
@Service("commentService")
public class CommentServiceImpl implements ICommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private IArticleService articleService;

    @Override
    public int deleteByCid(Long commentId) {
        return commentMapper.deleteByCid(commentId);
    }

    @Transactional
    @Override
    public int insertOne(Comment comment) {

        try{
            commentMapper.insertOne(comment);
            Article article = articleService.selectOneById(comment.getCommentArticleId());
            Article article1 = new Article();
            article1.setArticleId(article.getArticleId());
            article1.setCommentCount(article.getCommentCount()+1);
            articleService.updateCommentsBySelective(article1);
        }catch (Exception e){
            System.out.println("评论数据库操作错误");
            return 0;
        }

        return 1;
    }

    @Override
    public Comment selectOneByCid(Long commentId) {
        return commentMapper.selectOneByCid(commentId);
    }

    @Override
    public List<Comment> selectAllByAid(Long aid) {
        return commentMapper.selectAllByAid(aid);
    }

    @Override
    public int updateByComment(Comment comment) {
        return 0;
    }
}
