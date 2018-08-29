package service.impl;

import dao.ArticleMapper;
import entity.Article;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.IArticleService;
import service.IUserService;

import java.util.List;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 上午10:23 18-8-21
 * @Modified: null
 */
@Service("articleService")
public class ArticleServiceImpl implements IArticleService{

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private IUserService userService;

    @Override
    public int insertOne(Article article) {
        return articleMapper.insertOne(article);
    }

    @Override
    public List<Article> selectAll() {
        return articleMapper.selectAll();
    }

    @Override
    public List<Article> searchSome(String title) {
        return articleMapper.searchSome(title);
    }

    @Override
    public List<Article> selectFashionArticle() {
        return articleMapper.selectFashionArticle();
    }

    @Override
    public List<Article> selectAllUnchecked() {
        return articleMapper.selectAllUnchecked();
    }

    @Override
    public List<Article> selectAllChecked() {
        return articleMapper.selectAllChecked();
    }

    @Override
    public List<Article> selectAllCheckedByUserid(Integer userid) {
        return articleMapper.selectAllCheckedByUserid(userid);
    }

    @Override
    public List<Article> selectAllUncheckByUserid(Integer userid) {
        return articleMapper.selectAllUncheckByUserid(userid);
    }

    @Override
    public List<Article> selectAllOfUserid(Integer userid) {
        return articleMapper.selectAllOfUserid(userid);
    }


    @Override
    public List<Article> selectAllByClassid(Integer classid) {
        return articleMapper.selectAllByClassid(classid);
    }

    @Override
    public Integer selectCommentsOfUser(Integer userid) {
        return articleMapper.selectCommentsOfUser(userid);
    }

    @Override
    public Integer selectlikesOfUser(Integer userid) {
        return articleMapper.selectlikesOfUser(userid);
    }

    @Override
    public Article selectOneById(Long aid) {
        return articleMapper.selectOneById(aid);
    }

    @Override
    public int deleteOneByAid(Long aid) {
        return articleMapper.deleteOneByAid(aid);
    }

    @Transactional
    @Override
    public int updateOneBySelective(Article article) {
        try{

            articleMapper.updateOneBySelective(article);
            Article article1 = articleMapper.selectOneById(article.getArticleId());
            User user = userService.selectById(article1.getArticleAuthorId());

            User user1 = new User();
            user1.setUserId(user.getUserId());
            user1.setUserMark(user.getUserMark()+10);
            user1.setUserRankId((user1.getUserMark()/50)+1);
            userService.updateBySelectiveMark(user1);
        }catch (Exception e){
            System.out.println("数据库操作错误");
            return 0;
        }

        return 1;
    }

    @Override
    public int updateCommentsBySelective(Article article) {
        return articleMapper.updateOneBySelective(article);
    }
}
