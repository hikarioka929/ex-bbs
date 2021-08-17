package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Article;
import com.example.demo.form.InsertArticleForm;
import com.example.demo.service.ArticleService;

/**
 * 掲示板関連機能の処理の制御を行うコントローラ.
 * 
 * @author okahikari
 *
 */
@Controller
@RequestMapping("/board")
public class BbsController {
	
	@Autowired
	private ArticleService articleService;
	
	@ModelAttribute
	public InsertArticleForm setUpInsertArticleForm() {
		InsertArticleForm form = new InsertArticleForm();
		return form;
	}
	
	/**
	 * 記事一覧画面を表示する.
	 * @return 記事一覧画面
	 */
	@RequestMapping("")
	public String index(Model model) {
		List<Article> articleList = articleService.searchAll();
		model.addAttribute("articleList", articleList);
		return "top";
	}
	
	/**
	 * 渡された記事情報を保存する.
	 * @param form 入力された値が詰まったオブジェクト
	 * @return 記事一覧画面
	 */
	@RequestMapping("/save")
	public String save(InsertArticleForm form) {
		Article article = new Article();
		BeanUtils.copyProperties(form, article);
		articleService.save(article);
		return "redirect:/board";
	}
}
