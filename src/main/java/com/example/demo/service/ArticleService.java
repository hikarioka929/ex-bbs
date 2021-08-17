package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Article;
import com.example.demo.repository.ArticleRepository;

/**
 * 記事関連機能の業務処理を行うサービス.
 * 
 * @author okahikari
 *
 */
@Service
@Transactional
public class ArticleService {
	
	@Autowired
	private ArticleRepository articleRepository;
	
	/**
	 * 全記事情報を取得する.
	 * @return 全記事情報
	 */
	public List<Article> searchAll(){
		List<Article> articleList = articleRepository.findAll();
		return articleList;
	}
	
	/**
	 * 渡した記事情報を保存する.
	 * @param 記事情報
	 * @return 追加された後の記事情報
	 */
	public Article save(Article article) {
		Article insertArticle = articleRepository.insert(article);
		return insertArticle;
	}
}
