package service;

import entity.Reply;

import java.util.List;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午9:11 18-8-24
 * @Modified: null
 */
public interface IReplyService {
    int deleteByRid( Long replyId);

    int insertOne(Reply reply);

    List<Reply> selectByCid(Long Cid);
}
