package cn.wangliang.blog.controller;

import cn.wangliang.blog.service.ArticleService;
import cn.wangliang.blog.service.CategoryService;
import cn.wangliang.blog.service.CommentService;
import cn.wangliang.blog.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 基础控制器，包含了Controller层中共有的一些Service
 *
 * @author:wangliang
 */
public class BaseController {
    @Autowired
    ArticleService articleService;
    @Autowired
    CommentService commentService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    MessageService messageService;
}
