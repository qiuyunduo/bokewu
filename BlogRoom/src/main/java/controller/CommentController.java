package controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import entity.Comment;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.ICommentService;
import service.IUserService;
import util.CommentInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午5:21 18-8-20
 * @Modified: null
 */
@Controller
@RequestMapping("comment")
public class CommentController {
    @Autowired
    private ICommentService commentService;

    @Autowired
    private IUserService userService;

    @RequestMapping("addComment")
    @ResponseBody
    public String addComment(Comment comment){

        int rs = commentService.insertOne(comment);
        return rs+"";
    }

    //进入文章详情界面的方法(获得文章所有评论)
    @RequestMapping(value = "getCommentsByAId",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getCommentsByAId(Long aid){
        List<CommentInfo> commentInfos = new ArrayList<>();

        List<Comment> comments = commentService.selectAllByAid(aid);
//        System.out.println(comments);

        for (Comment comment : comments) {
            CommentInfo commentInfo = new CommentInfo();

            User user = userService.selectById(comment.getCommentAuthorId());

            commentInfo.setComment(comment);
            commentInfo.setCommentor(user);

            commentInfos.add(commentInfo);

        }
        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
        String commentInfosJson = JSON.toJSONString(commentInfos, SerializerFeature.WriteDateUseDateFormat);
        return commentInfosJson;
    }
}
