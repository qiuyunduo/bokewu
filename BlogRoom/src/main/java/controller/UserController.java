package controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import entity.Attention;
import entity.Rank;
import service.IArticleService;
import service.IAttentionService;
import service.IRankService;
import util.BlogInfo;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import service.IUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午7:12 18-8-13
 * @Modified: null
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @Autowired
    private IAttentionService attentionService;

    @Autowired
    private IRankService rankService;

    @Autowired
    private IArticleService articleService;

    @RequestMapping(value = "checkLog",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String CheckLog(HttpSession session){
        User user = null;
        user = (User)session.getAttribute("logUser");
//        System.out.println(user);
        String jsonUser = JSON.toJSONString(user);
        return jsonUser;
    }


    @RequestMapping("register")
    @ResponseBody
    public String Register(User user){
//        System.out.println(user);

        int rs = userService.insertOne(user);
        return rs+"";
    }

    @RequestMapping("login")
    @ResponseBody
    public String login(String lusername, String lpassword, HttpSession session){
//        System.out.println(lusername+" sss  "+lpassword);
        User user = userService.selectByNamePwd(lusername, lpassword);
//        System.out.println(user);
        if(user != null){
            session.setAttribute("logUser",user);
            return "1";
        }
        return "0";
    }

    @RequestMapping("backlogin")
    @ResponseBody
    public String backlogin(String userName, String userPwd, HttpSession session){
        User user = userService.selectAdmin(userName, userPwd);
        System.out.println(user);
        if(user != null){
            session.setAttribute("backLogUser",user);
            return "1";
        }
        return "0";
    }

    @RequestMapping(value = "getLogUser",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getLogUser(HttpSession session){
        User user = (User)session.getAttribute("logUser");

        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
        String jsonUser = JSON.toJSONString(user, SerializerFeature.WriteDateUseDateFormat);
        return jsonUser;
    }

    //获得最新注册的十位用户
    @RequestMapping(value = "getFashionUsers",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getFashionUsers(){
        List<User> users = userService.selectFashionUser();
        String usersJson = JSON.toJSONString(users);
        return usersJson;
    }

    public List<User> getUsersByIds(List<Integer> attentions){
        List<User> users = new ArrayList<>();
        for(Integer attention : attentions){
            User user = userService.selectById(attention);
            users.add(user);
        }

        return users;

    }

    @RequestMapping(value = "getBlogInfo",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getBlogInfo(Integer uid){
        BlogInfo blogInfo = new BlogInfo();

        User user = userService.selectById(uid);
        Rank rank = rankService.selectOneByRid(user.getUserRankId());

        List<Integer> attentions = attentionService.selectAllOfGid(uid);
        List<Integer> fans = attentionService.selectAllOfFid(uid);
        List<User> attentionUser = getUsersByIds(attentions);
        List<User> fanUser = getUsersByIds(fans);

        Integer comments = articleService.selectCommentsOfUser(uid);
        Integer likes = articleService.selectlikesOfUser(uid);


        blogInfo.setRank(rank);
        blogInfo.setLogUser(user);
        blogInfo.setAttentions(attentionUser);
        blogInfo.setFans(fanUser);
        blogInfo.setCommentcounts(comments);
        blogInfo.setLikecounts(likes);

        String jsonData = JSON.toJSONString(blogInfo);
        return jsonData;
    }


    @RequestMapping(value = "/updateHead")
    @ResponseBody
    public String updateHead(HttpServletRequest request, MultipartFile userhead) {
        System.out.println("进入上传头像方法");
        //上传路径
        String path = request.getServletContext().getRealPath("/upload/userhead");
        System.out.println(path);
        String filename = userhead.getOriginalFilename();
        System.out.println(filename);
        String suffix = filename.substring(filename.lastIndexOf("."));

        String newFillName = UUID.randomUUID()+suffix;

        User logUser = (User)request.getSession().getAttribute("logUser");
        User user = new User();
        user.setUserImageUrl(newFillName);
        user.setUserId(logUser.getUserId());
        int i = userService.updateBySelectiveImg(user);

        request.getSession().setAttribute("logUser",userService.selectById(logUser.getUserId()));

        File newfile = new File(path+File.separator+newFillName);
        try {
            userhead.transferTo(newfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return i+"";
    }

    @RequestMapping(value = "/updateInfo")
    @ResponseBody
    public String updateInfo(User user,@RequestParam("birthday")String birthday,HttpSession session){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date userBirthday = null;
        try {
            if(birthday != "") {
                userBirthday = format.parse(birthday);
            }
            user.setUserBirthday(userBirthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
//        System.out.println("user:传过来的对象"+user);
        int i = userService.updateBySelectiveInfo(user);

        session.setAttribute("logUser",userService.selectById(user.getUserId()));

        return i+"";
    }

    @RequestMapping(value = "/updatePwd")
    @ResponseBody
    public String updateInfo(User user,HttpSession session){
//        System.out.println("user:传过来的对象"+user);
        int i = userService.updateBySelectivePwd(user);

        session.setAttribute("logUser",userService.selectById(user.getUserId()));

        return i+"";
    }

    @RequestMapping("quitLog")
    public String quitlog(HttpSession session){
//       session.invalidate();
        session.setAttribute("logUser",null);
       return "redirect:/apps/index.html";
    }

    @RequestMapping("backQuitLog")
    public String backQuitLog(HttpSession session){
        session.setAttribute("backLogUser",null);
        return "redirect:/admin/login.html";
    }

    @RequestMapping(value = "getAll",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getAll(Integer pageNum) {
        PageHelper.startPage(pageNum,6);
        List<User> users = userService.selectAll();
        PageInfo<User> pageInfo = new PageInfo<>(users);
        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
        String jsonUsers = JSON.toJSONString(pageInfo, SerializerFeature.WriteDateUseDateFormat);
        return jsonUsers;
    }

    @RequestMapping(value = "lockUser",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String lockUser(Integer uid) {
        System.out.println("锁定");
        return "1";
    }


}
