package com.survivalcoding.kotlin_datasource.repository

import com.survivalcoding.kotlin_datasource.data_source.ItemDataSource
import com.survivalcoding.kotlin_datasource.model.Item

class ItemRepositoryImpl(
	private val dataSource: ItemDataSource,  // 데이터 소스를 생성자로 받아서 캡슐화할 것
): ItemRepository {
	/*
	< Respository 네이밍 규칙 >
	- '인터페이스' + Impl : 업계 표준
	
	< Repository >
	- 데이터 소스 인터페이스를 '생성자'로 받음. 어떤 기술인지 몰라도 됨
	- 데이터 소스를 숨기고 상위 계층에서 일관된 방법으로 데이터에 접근하는 방식을 제공
	- 데이터를 비즈니스 로직에 전달
	- 도메인 특화 기능을 제공
	 */
	
	override fun getItems(): List<Item> {
		// 비즈니스 규칙 : 이름 오름차순 정렬
		return dataSource.loadItems().sortedBy { it.name }
	}
	
	override fun getItem(id: Long): Item? {
		return dataSource.loadItems().find { it.id == id }
	}
	
	override fun getItemUnderPrice(maxPrice: Int): List<Item> {
		return dataSource.loadItems().filter { it.price <= maxPrice }
	}
	
	override fun searchByName(name: String): List<Item> {
		return dataSource.loadItems().filter {
			it.name.contains(name, ignoreCase = true)
		}
	}
	
	override fun searchByNameDesc(name: String): List<Item> {
		return dataSource.loadItems().filter {
			it.name.contains(name, ignoreCase = true)
		}.sortedByDescending { it.name }
	}
	
	override fun addItem(item: Item) {
		val currentItems = dataSource.loadItems().toMutableList()
		currentItems.add(item)
		dataSource.saveItems(currentItems)
	}
	
	override fun deleteItem(id: Long) {
		val currentItems = dataSource.loadItems().filterNot { it.id == id }
		dataSource.saveItems(currentItems)
	}
}