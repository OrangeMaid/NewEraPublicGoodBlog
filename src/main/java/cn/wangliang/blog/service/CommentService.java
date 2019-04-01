package cn.wangliang.blog.service;

import cn.wangliang.blog.dto.ArticleCommentDto;
import cn.wangliang.blog.entity.Comment;

import java.util.List;

/**
 * 留言的Service
 */
public interface CommentService {
    void addComment(Comment comment);

    void addArticleComment(ArticleCommentDto articleCommentDto);

    void deleteCommentById(Long id);

    void deleteArticleCommentById(Long id);

    List<Comment> listAllComment();

    List<Comment> listAllCommentByArticleId(long id);
}
