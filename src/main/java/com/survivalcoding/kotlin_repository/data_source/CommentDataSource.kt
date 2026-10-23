package com.survivalcoding.kotlin_repository.data_source

import com.survivalcoding.kotlin_repository.model.Comment

interface CommentDataSource {
	fun loadComments(): List<Comment>
	fun saveComments(comments: List<Comment>)
}
