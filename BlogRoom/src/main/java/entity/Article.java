package entity;

import java.util.Date;

public class Article {

    private Long articleId;
    private Integer articleClassId;
    private Integer articleAuthorId;
    private String articleDescribe;
    private String articleContent;
    private String articleTitle;
    private String articleKeyword;
    private Date articleTime;
    private String articlePic;
    private Byte articleStatus;
    private Integer commentCount;
    private Integer thumbsCount;

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Integer getArticleClassId() {
        return articleClassId;
    }

    public void setArticleClassId(Integer articleClassId) {
        this.articleClassId = articleClassId;
    }

    public Integer getArticleAuthorId() {
        return articleAuthorId;
    }

    public void setArticleAuthorId(Integer articleAuthorId) {
        this.articleAuthorId = articleAuthorId;
    }

    public String getArticleDescribe() {
        return articleDescribe;
    }

    public void setArticleDescribe(String articleDescribe) {
        this.articleDescribe = articleDescribe;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleKeyword() {
        return articleKeyword;
    }

    public void setArticleKeyword(String articleKeyword) {
        this.articleKeyword = articleKeyword;
    }

    public Date getArticleTime() {
        return articleTime;
    }

    public void setArticleTime(Date articleTime) {
        this.articleTime = articleTime;
    }

    public String getArticlePic() {
        return articlePic;
    }

    public void setArticlePic(String articlePic) {
        this.articlePic = articlePic;
    }

    public Byte getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(Byte articleStatus) {
        this.articleStatus = articleStatus;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getThumbsCount() {
        return thumbsCount;
    }

    public void setThumbsCount(Integer thumbsCount) {
        this.thumbsCount = thumbsCount;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", articleClassId=" + articleClassId +
                ", articleAuthorId=" + articleAuthorId +
                ", articleDescribe='" + articleDescribe + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleKeyword='" + articleKeyword + '\'' +
                ", articleTime=" + articleTime +
                ", articlePic='" + articlePic + '\'' +
                ", articleStatus=" + articleStatus +
                ", commentCount=" + commentCount +
                ", thumbsCount=" + thumbsCount +
                '}';
    }
}