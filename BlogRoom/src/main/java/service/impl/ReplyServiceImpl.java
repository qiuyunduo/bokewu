package service.impl;

import dao.ReplyMapper;
import entity.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.IReplyService;

import java.util.List;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午9:44 18-8-24
 * @Modified: null
 */
@Service("replyService")
public class ReplyServiceImpl implements IReplyService{
    @Autowired
    private ReplyMapper replyMapper;

    @Override
    public int deleteByRid(Long replyId) {
        return replyMapper.deleteByRid(replyId);
    }

    @Override
    public int insertOne(Reply reply) {
        return replyMapper.insertOne(reply);
    }

    @Override
    public List<Reply> selectByCid(Long Cid) {
        return replyMapper.selectByCid(Cid);
    }
}
