package com.example.demo.form;

import javax.validation.constraints.*;

/**
 * 記事投稿時に使用するフォーム.
 * 
 * @author okahikari
 *
 */
public class InsertArticleForm {

	/** 名前 */
	@NotBlank(message="名前は必須です")
	private String name;
	/** 記事内容 */
	@NotBlank(message="記事内容は必須です")
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
