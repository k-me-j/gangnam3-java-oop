package com.survivalcoding.kotlin_repository.repository

import com.survivalcoding.kotlin_repository.data_source.FakeCommentDataSource
import com.survivalcoding.kotlin_repository.model.Comment
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CommentRepositoryImplTest {
	private lateinit var fakeDataSource: FakeCommentDataSource
	private lateinit var repository: CommentRepository
	
	@BeforeEach
	fun setUp() {
		fakeDataSource = FakeCommentDataSource()
		fakeDataSource.saveComments(
			listOf(
				Comment(
					postId = 1L,
					id = 1L,
					name = "id labore ex et quam laborum",
					email = "Eliseo@gardner.biz",
					body = """
            laudantium enim quasi est quidem magnam voluptate ipsam eos
        """.trimIndent()
				),
				Comment(
					postId = 1L,
					id = 2L,
					name = "quo vero reiciendis velit similique earum",
					email = "Jayne_Kuhic@sydney.com",
					body = """
            est natus enim nihil est dolore omnis voluptatem numquam
        """.trimIndent()
				),
				Comment(
					postId = 2L,
					id = 3L,
					name = "odio adipisci rerum aut animi",
					email = "Nikita@garfield.biz",
					body = """
            quia molestiae reprehenderit quasi aspernatur
        """.trimIndent()
				)
			)
		)
		
		repository = CommentRepositoryImpl(fakeDataSource)
	}
	
	@Test
	fun `지정한 postId에 맞는 데이터를 반환`() {
		val commentsByPostId = repository.getComments(1L)
		
		assertEquals(2, commentsByPostId.size)
		assertTrue(commentsByPostId.any {it.name.contains("id labore ex et quam laborum")})
	}
}