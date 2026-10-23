package com.survivalcoding.kotlin_datasource.repository

import com.survivalcoding.kotlin_datasource.model.Item

interface ItemRepository {
	fun getItems(): List<Item>
	fun getItem(id: Long): Item?
	fun getItemUnderPrice(maxPrice: Int): List<Item>
	fun searchByName(name: String): List<Item>
	fun searchByNameDesc(name: String): List<Item>  // 내림차순
	fun addItem(item: Item)
	fun deleteItem(item: Item)
	
	// 위에 나열한 기능들을 다 만들지 않아도 됨. 그냥 이런게 있을거야~ 만들어 놓기만 해도 됨
}