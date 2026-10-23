package com.survivalcoding.kotlin_repository.repository

import com.survivalcoding.kotlin_repository.model.Comment

interface CommentRepository {
	fun getComments(postId: Long): List<Comment>
}