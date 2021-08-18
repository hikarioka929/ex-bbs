package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Comment;

/**
 * commentsテーブルを操作するリポジトリ(Dao).
 * 
 * @author okahikari
 *
 */
@Repository
public class CommentRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Comment> COMMENT_ROW_MAPPER
	= new BeanPropertyRowMapper<>(Comment.class);
	
	/**
	 * 記事IDからコメント情報を取得する.
	 * @param articleId 記事ID
	 * @return コメント情報
	 */
	public List<Comment> findByArticleId(int articleId){
		String sql = "SELECT id, name, content, article_id FROM comments WHERE article_id = :articleId;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("articleId", articleId);
		List<Comment> commentList = template.query(sql, param, COMMENT_ROW_MAPPER);
		return commentList;
	}
	
	/**
	 * 渡したコメント情報を保存する.
	 * @param comment コメント情報
	 */
	public void insert(Comment comment) {
		SqlParameterSource param
		= new BeanPropertySqlParameterSource(comment);
		String sql = "INSERT INTO comments(name, content, article_id) VALUES (:name, :content, :articleId);";
		template.update(sql, param);
	}
}
