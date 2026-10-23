package com.survivalcoding.kotlin_repository.data_source

import com.survivalcoding.kotlin_repository.model.Comment

class FakeCommentDataSource: CommentDataSource {
	private var comments: List<Comment> = emptyList()
	
	override fun loadComments(): List<Comment> = comments
	
	override fun saveComments(comments: List<Comment>) {
		this.comments = comments
	}
}