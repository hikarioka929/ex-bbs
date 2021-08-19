package com.example.demo.form;

import javax.validation.constraints.*;

/**
 * コメント投稿時に使用するフォーム.
 * 
 * @author okahikari
 *
 */
public class CommentForm {

	/** 名前 */
	@NotBlank(message = "名前は必須です")
	private String name;
	/** コメント内容 */
	@NotBlank(message = "コメント内容は必須です")
	private String content;
	/** 記事ID */
	private String articleId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	
	public Integer getIntArticleId() {
		return Integer.parseInt(articleId);
	}

	@Override
	public String toString() {
		return "CommentForm [name=" + name + ", content=" + content + ", articleId=" + articleId + "]";
	}

}
