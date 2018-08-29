package entity;

public class Reply {

    private Long replyId;

    private Long replyCommentId;

    private Integer replyAuthorId;

    private String replyContent;

    public Long getReplyId() {
        return replyId;
    }

    public void setReplyId(Long replyId) {
        this.replyId = replyId;
    }

    public Long getReplyCommentId() {
        return replyCommentId;
    }

    public void setReplyCommentId(Long replyCommentId) {
        this.replyCommentId = replyCommentId;
    }

    public Integer getReplyAuthorId() {
        return replyAuthorId;
    }

    public void setReplyAuthorId(Integer replyAuthorId) {
        this.replyAuthorId = replyAuthorId;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "replyId=" + replyId +
                ", replyCommentId=" + replyCommentId +
                ", replyAuthorId=" + replyAuthorId +
                ", replyContent='" + replyContent + '\'' +
                '}';
    }
}