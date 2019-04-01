package cn.wangliang.blog.service.impl;

import cn.wangliang.blog.dao.ArticleCommentMapper;
import cn.wangliang.blog.dao.CommentMapper;
import cn.wangliang.blog.dto.ArticleCommentDto;
import cn.wangliang.blog.entity.ArticleComment;
import cn.wangliang.blog.entity.Comment;
import cn.wangliang.blog.entity.CommentExample;
import cn.wangliang.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 评论Service实现类
 * @author:wangliang
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;
    @Autowired
    ArticleCommentMapper articleCommentMapper;

    /**
     * 增加一条留言信息
     *
     * @param comment
     */
    @Override
    public void addComment(Comment comment) {
        commentMapper.insertSelective(comment);
    }

    /**
     * 增加一条文章评论信息
     * 说明：ArticleCommentDto中封装了tbl_comment和tbl_article_comment中的基础数据
     *
     * @param articleCommentDto
     */
    @Override
    public void addArticleComment(ArticleCommentDto articleCommentDto) {
        // 先增加Comment留言数据
        Comment comment = new Comment();
        comment.setIp(articleCommentDto.getIp());
        comment.setName(articleCommentDto.getName());
        comment.setEmail(articleCommentDto.getEmail());
        comment.setContent(articleCommentDto.getContent());
        comment.setArticleId(articleCommentDto.getArticleId());
        comment.setCreateBy(new Date());
        addComment(comment);
    }

    /**
     * 通过留言ID删除一条数据
     * @param id
     */
    @Override
    public void deleteCommentById(Long id) {
        commentMapper.deleteByPrimaryKey(id);
    }

    /**
     * 删除文章评论信息
     * 说明：说明：并不是直接删除数据库中的数据而是直接将isEffective字段置为false
     * 注意：这里需要设置两个表的字段
     *
     * @param id tbl_article_comment表主键
     */
    @Override
    public void deleteArticleCommentById(Long id) {
        // 设置ArticleComment表中的字段为false
        ArticleComment articleComment = articleCommentMapper.selectByPrimaryKey(id);
        articleComment.setIsEffective(false);
        articleCommentMapper.updateByPrimaryKeySelective(articleComment);
        // 删除Comment表中对应的数据
        deleteCommentById(articleComment.getCommentId());
    }

    /**
     * 列举返回所有的留言信息
     *
     * @return
     */
    @Override
    public List<Comment> listAllComment() {
        // 无条件查询即返回所有
        CommentExample example = new CommentExample();
        return commentMapper.selectByExample(example);
    }
    /**
     * 通过文章id获得该文章的所有评论
     * @param id
     * @return
     */

    @Override
    public List<Comment> listAllCommentByArticleId(long id) {
         CommentExample example = new CommentExample();
        example.or().andArticleIdEqualTo(id);
        List<Comment> listComment = commentMapper.selectByExample(example);
        return listComment;
    }


}
