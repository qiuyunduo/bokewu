package dao;

import entity.Reply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReplyMapper {
    int deleteByRid(@Param("replyId") Long replyId);

    int insertOne(Reply reply);

    List<Reply> selectByCid(@Param("Cid")Long Cid);

}