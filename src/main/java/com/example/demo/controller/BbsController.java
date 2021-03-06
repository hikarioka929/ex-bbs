package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.domain.Article;
import com.example.demo.domain.Comment;
import com.example.demo.form.CommentForm;
import com.example.demo.form.InsertArticleForm;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.repository.CommentRepository;

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
	private ArticleRepository articleRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@ModelAttribute
	public InsertArticleForm setUpInsertArticleForm() {
		InsertArticleForm form = new InsertArticleForm();
		return form;
	}
	
	@ModelAttribute
	public CommentForm setUpCommentForm() {
		CommentForm form = new CommentForm();
		return form;
	}
	
	/**
	 * 記事一覧画面を表示する.
	 * @return 記事一覧画面
	 */
	@RequestMapping("")
	public String index(Model model) {
		List<Article> articleList = articleRepository.findAll();
		model.addAttribute("articleList", articleList);
		return "top";
	}
	
	/**
	 * 渡された記事情報を保存する.
	 * @param form 入力された値が詰まったオブジェクト
	 * @return 記事一覧画面
	 */
	@RequestMapping("/save")
	public String insertArticle(@Validated InsertArticleForm form, BindingResult result, RedirectAttributes redirectAttributes, Model model) {
		if(result.hasErrors()) {
			return index(model);
		}
		Article article = new Article();
		BeanUtils.copyProperties(form, article);
		articleRepository.insert(article);
		return "redirect:/board";
	}
	
	/**
	 * 渡されたコメント情報を保存する.
	 * @param form 入力された値が詰まったオブジェクト
	 * @return 記事一覧画面
	 */
	@RequestMapping("/insert-comment")
	public String insertComment(@Validated CommentForm form, BindingResult result, RedirectAttributes redirectAttributes, Model model) {
		if(result.hasErrors()) {
			return index(model);
		}
		Comment comment = new Comment();
		BeanUtils.copyProperties(form, comment);
		comment.setArticleId(Integer.parseInt(form.getArticleId()));
		commentRepository.insert(comment);
		return "redirect:/board";
	}
	
	/**
	 * 渡された記事情報を削除する.
	 * (記事情報に関連したコメントも削除する)
	 * @param id 記事ID
	 * @return 記事一覧画面
	 */
	@RequestMapping("/delete-article")
	public String deleteArticle(Integer id) {
		articleRepository.deleteById(id);
		return "redirect:/board";
	}
}
