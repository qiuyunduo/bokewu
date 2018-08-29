package ArticleTest;

import entity.Article;
import entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.IArticleService;
import service.IUserService;
import service.impl.ArticleServiceImpl;

import java.util.List;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 上午10:31 18-8-21
 * @Modified: null
 */
public class test1 {
    @Test
    public void insertOne(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("mybatis-spring.xml");

        IArticleService articleService = context.getBean(IArticleService.class);
        Article article = new Article();
        article.setArticleAuthorId(1);
        article.setArticleClassId(1);
        article.setArticlePic("001.jpg");
        article.setArticleTitle("test1");
        article.setArticleContent("111111111111111111111111111111");
        article.setArticleKeyword("java,php");
        articleService.insertOne(article);
    }

    @Test
    public void inseruser(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("mybatis-spring.xml");

        IUserService userService = context.getBean(IUserService.class);
        User user = new User();
        user.setUserName("王五");
        user.setUserPwd("12345");
        user.setUserEmail("123@aliyun.com");
        userService.insertOne(user);
    }

    @Test
    public void getallByUserid(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("mybatis-spring.xml");

        IArticleService articleService = context.getBean(IArticleService.class);
        List<Article> articles = articleService.selectAllOfUserid(19);
        System.out.println(articles);
    }
}
