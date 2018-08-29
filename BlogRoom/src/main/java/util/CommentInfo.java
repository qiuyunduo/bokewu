package util;

import entity.Comment;
import entity.Reply;
import entity.User;

import java.util.List;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午10:00 18-8-23
 * @Modified: null
 */
public class CommentInfo {
    private Comment comment;
    private User commentor;

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public User getCommentor() {
        return commentor;
    }

    public void setCommentor(User commentor) {
        this.commentor = commentor;
    }

    @Override
    public String toString() {
        return "CommentInfo{" +
                "comment=" + comment +
                ", commentor=" + commentor +
                '}';
    }
}
