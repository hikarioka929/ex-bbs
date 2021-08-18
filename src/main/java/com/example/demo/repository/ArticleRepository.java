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

import com.example.demo.domain.Article;

/**
 * articlesテーブルを操作するリポジトリ(Dao).
 * 
 * @author okahikari
 *
 */
@Repository
public class ArticleRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Article> ALTICLE_ROW_MAPPER
	= new BeanPropertyRowMapper<>(Article.class);
	
	/**
	 * 全記事情報を取得する.
	 * (記事が存在しない場合はサイズ0件の記事一覧を返す)。
	 * @return 全記事情報
	 */
	public List<Article> findAll(){
		String sql ="SELECT id, name, content FROM articles ORDER BY id DESC;";
		List<Article> articleList = template.query(sql, ALTICLE_ROW_MAPPER);
		return articleList;
	}
	
	/**
	 * 渡した記事情報を保存する.
	 * @param article 記事情報
	 */
	public void insert(Article article) {
		SqlParameterSource param
		= new BeanPropertySqlParameterSource(article);
		String sql = "INSERT INTO articles(name, content) VALUES (:name, :content);";
		template.update(sql, param);
	}
	
	/**
	 * 渡された記事情報を削除する.
	 * (記事情報に関連するコメントも削除する)
	 * @param id 記事ID
	 */
	public void deleteById(int id) {
		String sql = "DELETE FROM articles WHERE id = :id;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		template.update(sql, param);
	}
}
