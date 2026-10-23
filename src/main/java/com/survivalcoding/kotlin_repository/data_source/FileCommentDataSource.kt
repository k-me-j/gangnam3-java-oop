package com.survivalcoding.kotlin_repository.data_source

import com.survivalcoding.kotlin_repository.model.Comment
import kotlinx.serialization.json.Json
import java.io.File

class FileCommentDataSource(
	private val file: File = File("comments.json"),
) : CommentDataSource {

	override fun loadComments(): List<Comment> {
		if (!file.exists()) {
			return emptyList()
		}

		val jsonText = file.readText()
		if (jsonText.isBlank()) {
			return emptyList()
		}

		return Json.decodeFromString<List<Comment>>(jsonText)
	}

	override fun saveComments(comments: List<Comment>) {
		val jsonText = Json.encodeToString(comments)
		file.writeText(jsonText)
	}
}
