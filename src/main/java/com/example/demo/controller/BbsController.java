package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Article;
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
}
