package util;

import entity.Article;
import entity.User;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 上午10:26 18-8-24
 * @Modified: null
 */
public class ArticleInfo {
    private Article article;
    private User author;

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "ArticleInfo{" +
                "article=" + article +
                ", author=" + author +
                '}';
    }
}
