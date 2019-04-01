package cn.wangliang.blog.dao;

import cn.wangliang.blog.entity.ArticleComment;
import cn.wangliang.blog.entity.ArticleCommentExample;
import cn.wangliang.blog.entity.Comment;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ArticleCommentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ArticleComment record);

    int insertSelective(ArticleComment record);

    List<ArticleComment> selectByExample(ArticleCommentExample example);

    ArticleComment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ArticleComment record);

    int updateByPrimaryKey(ArticleComment record);

    @Select("select * from tbl_message where article_id = #{id}")
    List<Comment> selectCommentByArtcleId(long id);
}