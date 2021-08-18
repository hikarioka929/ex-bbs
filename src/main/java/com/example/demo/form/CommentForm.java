package com.example.demo.form;

/**
 * コメント投稿時に使用するフォーム.
 * 
 * @author okahikari
 *
 */
public class CommentForm {

	/** 名前 */
	private String name;
	/** コメント内容 */
	private String content;
	/** 記事ID */
	private Integer articleId;

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

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	@Override
	public String toString() {
		return "CommentForm [name=" + name + ", content=" + content + ", articleId=" + articleId + "]";
	}
}
