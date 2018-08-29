package entity;

import java.util.Date;

public class Comment {

    private Long commentId;

    private Long commentArticleId;

    private Integer commentAuthorId;

    private Date commentDate;

    private Integer commentFloor;

    private String commentContent;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getCommentArticleId() {
        return commentArticleId;
    }

    public void setCommentArticleId(Long commentArticleId) {
        this.commentArticleId = commentArticleId;
    }

    public Integer getCommentAuthorId() {
        return commentAuthorId;
    }

    public void setCommentAuthorId(Integer commentAuthorId) {
        this.commentAuthorId = commentAuthorId;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public Integer getCommentFloor() {
        return commentFloor;
    }

    public void setCommentFloor(Integer commentFloor) {
        this.commentFloor = commentFloor;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", commentArticleId=" + commentArticleId +
                ", commentAuthorId=" + commentAuthorId +
                ", commentDate=" + commentDate +
                ", commentFloor=" + commentFloor +
                ", commentContent='" + commentContent + '\'' +
                '}';
    }
}