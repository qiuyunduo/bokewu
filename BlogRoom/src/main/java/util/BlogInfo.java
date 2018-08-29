package util;

import entity.Article;
import entity.Rank;
import entity.User;

import java.util.List;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午4:09 18-8-23
 * @Modified: null
 */
public class BlogInfo {
    private User user;
    private Rank rank;
    private List<User> attentions;
    private List<User> fans;
    private Integer likecounts;
    private Integer commentcounts;

    public User getUser() {
        return user;
    }

    public void setLogUser(User user) {
        this.user = user;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public List<User> getAttentions() {
        return attentions;
    }

    public void setAttentions(List<User> attentions) {
        this.attentions = attentions;
    }

    public List<User> getFans() {
        return fans;
    }

    public void setFans(List<User> fans) {
        this.fans = fans;
    }

    public Integer getLikecounts() {
        return likecounts;
    }

    public void setLikecounts(Integer likecounts) {
        this.likecounts = likecounts;
    }

    public Integer getCommentcounts() {
        return commentcounts;
    }

    public void setCommentcounts(Integer commentcounts) {
        this.commentcounts = commentcounts;
    }

    @Override
    public String toString() {
        return "BlogInfo{" +
                "logUser=" + user +
                ", rank=" + rank +
                ", attentions=" + attentions +
                ", fans=" + fans +
                ", likecounts=" + likecounts +
                ", commentcounts=" + commentcounts +
                '}';
    }
}
