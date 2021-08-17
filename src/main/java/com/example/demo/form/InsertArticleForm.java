package com.example.demo.form;

/**
 * 記事投稿時に使用するフォーム.
 * 
 * @author okahikari
 *
 */
public class InsertArticleForm {

	/** 名前 */
	private String name;
	/** 記事内容 */
	private String content;

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

	@Override
	public String toString() {
		return "InsertArticleForm [name=" + name + ", content=" + content + "]";
	}

}
