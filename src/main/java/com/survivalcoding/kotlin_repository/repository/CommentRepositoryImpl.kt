package com.survivalcoding.kotlin_repository.repository

import com.survivalcoding.kotlin_repository.data_source.CommentDataSource
import com.survivalcoding.kotlin_repository.model.Comment

class CommentRepositoryImpl(
	private val dataSource: CommentDataSource,
) : CommentRepository {
	
	override fun getComments(postId: Long): List<Comment> {
		return dataSource.loadComments().filter { it.postId == postId }
	}
}