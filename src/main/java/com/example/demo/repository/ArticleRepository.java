package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
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
}
