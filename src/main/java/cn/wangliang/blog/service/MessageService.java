package cn.wangliang.blog.service;

import cn.wangliang.blog.entity.Message;

import java.util.List;

/**
 * create by wangliang
 */
public interface MessageService {

    void addMessage(Message message);

    void deleteMessagetById(Long id);

    List<Message> listAllMessage();

    List<Message> listAllMessageByEffective();

}
