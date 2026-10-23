package com.survivalcoding.kotlin_datasource.repository

import com.survivalcoding.kotlin_datasource.data_source.FakeItemDataSource
import com.survivalcoding.kotlin_datasource.model.Item
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ItemRepositoryImplTest {
	private lateinit var fakeDataSource: FakeItemDataSource
	private lateinit var repository: ItemRepository
	
	@BeforeEach
	fun setUp() {
		// 1. 가짜 DataSource 생성 및 초기 데이터 세팅
		fakeDataSource = FakeItemDataSource()
		fakeDataSource.saveItems(
			listOf(
				Item(1L, "기계식 키보드", 120_000),
				Item(2L, "무선 마우스", 89_000),
				Item(3L, "27인치 모니터", 350_000),
			)
		)
		
		// 2. 데이터가 준비된 DataSource를 주입하여 Repository 생성
		repository = ItemRepositoryImpl(fakeDataSource)
	}
	
	@Test
	fun `지정한 금액 이하의 아이템만 조회된다`() {
		val affordableItems = repository.getItemUnderPrice(100_000)
		
		assertEquals(1, affordableItems.size)
		assertEquals("무선 마우스", affordableItems.first().name)
	}
}