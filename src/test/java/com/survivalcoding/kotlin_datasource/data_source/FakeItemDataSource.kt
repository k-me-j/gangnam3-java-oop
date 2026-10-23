package com.survivalcoding.kotlin_datasource.data_source

import com.survivalcoding.kotlin_datasource.model.Item

// 메모리 상에서 돌아가게 만든 테스트용 객체 준비
class FakeItemDataSource: ItemDataSource {
	private var items: List<Item> = emptyList()
	
	override fun loadItems(): List<Item> = items
	
	override fun saveItems(items: List<Item>) {
		this.items = items
	}
}
