package entity;

public class ArticleClass {
    private Integer articleClassId;

    private String articleClassName;

    private Integer articleClassPid;

    public Integer getArticleClassId() {
        return articleClassId;
    }

    public void setArticleClassId(Integer articleClassId) {
        this.articleClassId = articleClassId;
    }

    public String getArticleClassName() {
        return articleClassName;
    }

    public void setArticleClassName(String articleClassName) {
        this.articleClassName = articleClassName;
    }

    public Integer getArticleClassPid() {
        return articleClassPid;
    }

    public void setArticleClassPid(Integer articleClassPid) {
        this.articleClassPid = articleClassPid;
    }

    @Override
    public String toString() {
        return "ArticleClass{" +
                "articleClassId=" + articleClassId +
                ", articleClassName='" + articleClassName + '\'' +
                ", articleClassPid=" + articleClassPid +
                '}';
    }
}