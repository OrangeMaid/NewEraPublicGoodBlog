package cn.wangliang.blog.service.impl;

import cn.wangliang.blog.dao.MessageMapper;
import cn.wangliang.blog.entity.Message;
import cn.wangliang.blog.entity.MessageExample;
import cn.wangliang.blog.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * FileName: MessageServiceImpl
 * Author:  wangliang
 * Date:     2019/4/1 14:45
 * Description: 留言模块sv
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageMapper messageMapper;
    @Override
    public void addMessage(Message message) {
        message.setCreateBy(new Date());
        message.setIsEffective(true);
        messageMapper.insert(message);
    }

    @Override
    public void deleteMessagetById(Long id) {
        Message message = messageMapper.selectByPrimaryKey(id);
        message.setIsEffective(false);
        messageMapper.updateByPrimaryKey(message);
    }

    @Override
    public List<Message> listAllMessage() {
        // 默认查询全部
        MessageExample example = new MessageExample();
        return messageMapper.selectByExample(example);
    }

    /**
     *
     * 查询所有有效留言，给前台展示
     */
    @Override
    public List<Message> listAllMessageByEffective() {
        MessageExample example = new MessageExample();
        MessageExample.Criteria criteria = example.createCriteria();
        criteria.andIsEffectiveEqualTo(true);
        return messageMapper.selectByExample(example);
    }
}