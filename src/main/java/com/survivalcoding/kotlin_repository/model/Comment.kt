package com.survivalcoding.kotlin_repository.model

import kotlinx.serialization.Serializable

@Serializable
data class Comment(
	val postId: Long,
	val id: Long,
	val name: String,
	val email: String,
	val body: String,
)
