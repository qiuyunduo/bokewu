package controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import entity.Article;
import entity.Comment;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import service.IArticleService;
import service.ICommentService;
import service.IUserService;
import util.ArticleInfo;
import util.CommentInfo;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午5:20 18-8-20
 * @Modified: null
 */
@Controller
@RequestMapping("/article")
public class AtricleController {
    @Autowired
    private IArticleService articleService;

    @Autowired
    private IUserService userService;

    //获得最新的十篇文章
    @RequestMapping(value = "getFashionArticle",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getFashionArticle(){
        List<Article> articles = articleService.selectFashionArticle();
        String articlesJson = JSON.toJSONString(articles);
        return articlesJson;
    }

    //写文章,添加文章
    @RequestMapping("addArticle")
    @ResponseBody
    public String AddArticle(Article article,MultipartFile articleimg,HttpServletRequest request){
        String path = request.getServletContext().getRealPath("/upload/articlepic");
        if(articleimg != null) {
            String filename = articleimg.getOriginalFilename();
            String suffix = filename.substring(filename.lastIndexOf("."));
            String newFillName = "at" + UUID.randomUUID() + suffix;
            File newfile = new File(path + File.separator + newFillName);
            try {
                articleimg.transferTo(newfile);
            } catch (IOException e) {
                e.printStackTrace();
                return "2";
            }
            article.setArticlePic(newFillName);
        }
        int rs = articleService.insertOne(article);
        return rs+"";
    }

    //进入文章详情界面的方法(获得文章，和作者两个对象)
    @RequestMapping(value = "getOneById",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getOneById(Long aid){
        ArticleInfo articleInfo = new ArticleInfo();
        Article article = articleService.selectOneById(aid);
        User user = userService.selectById(article.getArticleAuthorId());
        articleInfo.setArticle(article);
        articleInfo.setAuthor(user);
        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
        String articleInfoJson = JSON.toJSONString(articleInfo, SerializerFeature.WriteDateUseDateFormat);
        return articleInfoJson;
    }

    public String transArticles(List<Article> articles,PageInfo pageInfo){

        List<ArticleInfo> articleInfos = new ArrayList<>();


        for (Article article : articles) {
            ArticleInfo articleInfo = new ArticleInfo();
            User user = userService.selectById(article.getArticleAuthorId());
            articleInfo.setArticle(article);
            articleInfo.setAuthor(user);
            articleInfos.add(articleInfo);

        }

        pageInfo.setList(articleInfos);
//        System.out.println(pageInfo);
        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
        String articleInfosJson = JSON.toJSONString(pageInfo,SerializerFeature.WriteDateUseDateFormat);
        return articleInfosJson;
    }

    //得到所有的文章方法，前台首页用到
    @RequestMapping(value = "getAll",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String GetAll(Integer pageNum){
        PageHelper.startPage(pageNum,6,true);
        List<Article> articles = articleService.selectAll();
        PageInfo<Article> pageInfo = new PageInfo(articles);

        return transArticles(articles,pageInfo);
    }

    //得到所有的文章方法，前台首页用到
    @RequestMapping(value = "getSearchRs",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getSearchRs(String title,Integer pageNum){
        PageHelper.startPage(pageNum,6,true);
        List<Article> articles = articleService.searchSome(title);
        PageInfo<Article> pageInfo = new PageInfo(articles);

        return transArticles(articles,pageInfo);
    }

    //得到所有某一类别的文章方法，前台首页用到
    @RequestMapping(value = "getAllOfClass",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getAllOfClass(Integer classid,Integer pageNum){
        PageHelper.startPage(pageNum,6,true);
        List<Article> articles = articleService.selectAllByClassid(classid);
        PageInfo<Article> pageInfo = new PageInfo(articles);

        return transArticles(articles,pageInfo);
    }

    //个人博客页面，获得所有属于该用户的文章(已审核通过的)
    @RequestMapping(value = "getArticlesOfUid",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getArticlesOfUid(Integer uid,Integer pageNum){
        PageHelper.startPage(pageNum,6,true);
        List<Article> articles = articleService.selectAllCheckedByUserid(uid);
        PageInfo<Article> pageInfo = new PageInfo(articles);

        return transArticles(articles,pageInfo);
    }

    //个人博客页面，获得所有属于该用户的文章(不论是否通过)
    @RequestMapping(value = "getAllArticlesOfUid",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getAllArticlesOfUid(Integer uid,Integer pageNum){
        PageHelper.startPage(pageNum,6,true);
        List<Article> articles = articleService.selectAllOfUserid(uid);
        PageInfo<Article> pageInfo = new PageInfo(articles);
        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
        String articlesJson = JSON.toJSONString(pageInfo,SerializerFeature.WriteDateUseDateFormat);
        return articlesJson;
    }

    @RequestMapping(value = "getAllCheckedArticlesOfUid",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getAllCheckedArticlesOfUid(Integer uid,Integer pageNum){
        PageHelper.startPage(pageNum,6,true);
        List<Article> articles = articleService.selectAllCheckedByUserid(uid);
        PageInfo<Article> pageInfo = new PageInfo(articles);
        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
        String articlesJson = JSON.toJSONString(pageInfo,SerializerFeature.WriteDateUseDateFormat);
        return articlesJson;
    }

    @RequestMapping(value = "getAllUncheckArticlesOfUid",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getAllUncheckArticlesOfUid(Integer uid,Integer pageNum){
        PageHelper.startPage(pageNum,6,true);
        List<Article> articles = articleService.selectAllUncheckByUserid(uid);
        PageInfo<Article> pageInfo = new PageInfo(articles);
        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
        String articlesJson = JSON.toJSONString(pageInfo,SerializerFeature.WriteDateUseDateFormat);
        return articlesJson;
    }

    //删除文章
    @RequestMapping(value = "deleteOneByAid",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String deleteOneByAid(Long aid){
        int rs = articleService.deleteOneByAid(aid);
        return rs+"";
    }

    //修改文章
    @RequestMapping(value = "updateArticle")
    @ResponseBody
    public String updateArticle(Article article,MultipartFile articleimg,HttpServletRequest request){
        String path = request.getServletContext().getRealPath("/upload/articlepic");
        if(articleimg != null) {
            String filename = articleimg.getOriginalFilename();
            String suffix = filename.substring(filename.lastIndexOf("."));
            String newFillName = "at" + UUID.randomUUID() + suffix;
            File newfile = new File(path + File.separator + newFillName);
            try {
                articleimg.transferTo(newfile);
            } catch (IOException e) {
                e.printStackTrace();
                return "2";
            }
            article.setArticlePic(newFillName);
        }

        System.out.println(article);
        int rs = articleService.updateOneBySelective(article);
        return rs+"";
    }

    @RequestMapping(value = "getAllUnchecked",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getAllUnchecked(Integer pageNum){
        PageHelper.startPage(pageNum,5,true);
        List<Article> articles = articleService.selectAllUnchecked();
        PageInfo<Article> pageInfo = new PageInfo(articles);
//        System.out.println(articles);
        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
        String articlesJson = JSON.toJSONString(pageInfo,SerializerFeature.WriteDateUseDateFormat);
        return articlesJson;
    }

    @RequestMapping(value = "getAllChecked",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getAllChecked(Integer pageNum){
        PageHelper.startPage(pageNum,5,true);
        List<Article> articles = articleService.selectAllChecked();
        PageInfo<Article> pageInfo = new PageInfo(articles);
        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
        String articlesJson = JSON.toJSONString(pageInfo,SerializerFeature.WriteDateUseDateFormat);
        return articlesJson;
    }

    //审核文章
    @RequestMapping(value = "updateOneByAid",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String updateOneByAid(Long aid){
        byte status = 1;
        Article article = new Article();
        article.setArticleId(aid);
        article.setArticleStatus(status);
        int rs = articleService.updateOneBySelective(article);
        return rs+"";
    }
}
