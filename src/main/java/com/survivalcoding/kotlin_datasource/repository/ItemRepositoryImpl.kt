package com.survivalcoding.kotlin_datasource.repository

import com.survivalcoding.kotlin_datasource.data_source.ItemDataSource
import com.survivalcoding.kotlin_datasource.model.Item

class ItemRepositoryImpl(
	private val dataSource: ItemDataSource,  // 데이터 소스를 생성자로 받아서 캡슐화할 것
): ItemRepository {
	override fun getItems(): List<Item> {
		TODO("Not yet implemented")
	}
	
	override fun getItem(id: Long): Item? {
		TODO("Not yet implemented")
	}
	
	override fun getItemUnderPrice(maxPrice: Int): List<Item> {
		TODO("Not yet implemented")
	}
	
	override fun searchByName(name: String): List<Item> {
		TODO("Not yet implemented")
	}
	
	override fun searchByNameDesc(name: String): List<Item> {
		TODO("Not yet implemented")
	}
	
	override fun addItem(item: Item) {
		TODO("Not yet implemented")
	}
	
	override fun deleteItem(item: Item) {
		TODO("Not yet implemented")
	}
}