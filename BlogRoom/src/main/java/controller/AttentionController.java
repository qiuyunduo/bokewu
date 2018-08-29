package controller;

import entity.Attention;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.IAttentionService;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午5:22 18-8-20
 * @Modified: null
 */
@Controller
@RequestMapping("attention")
public class AttentionController {
    @Autowired
    private IAttentionService attentionService;

    @RequestMapping("addAttention")
    @ResponseBody
    public String addAttention(Attention attention){
        System.out.println(attention);
        int rs = attentionService.insertOne(attention);
        return rs+"";
    }

    @RequestMapping("delAttention")
    @ResponseBody
    public String delAttention(Attention attention){
        System.out.println(attention);
        int rs = attentionService.deleteBySelective(attention);
        return rs+"";
    }
}
