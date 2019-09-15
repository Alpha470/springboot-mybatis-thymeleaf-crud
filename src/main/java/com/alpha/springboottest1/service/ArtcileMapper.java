package com.alpha.springboottest1.service;

import com.alpha.springboottest1.model.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArtcileMapper {

    @Select("select * from article where title like concat('%',#{title},'%')")
    List<Article> findArtcleBytitle(String title);

    @Update ("update article set " +
            "title = #{title}," +
            "mdContent = #{mdContent}," +
            "summary = #{summary} ," +
            "state = #{state} " +
            "where id=#{id} ")
    public  int updateArtcile(Article article);

    @Delete (" delete from article where id= #{id} ")
    public  int deleteArtcile(Integer id);

    @Insert ("insert into article (id,title,mdContent,summary,state) " +
            "values (#{id},#{title},#{mdContent},#{summary},#{state})")
    public  int insertArtcile(Article article);

    @Select("select * from article ")
    public List<Article> ListArticle();

    @Select("select * from article where id=#{id}")
    public Article getArticleById(Integer id) ;

}
