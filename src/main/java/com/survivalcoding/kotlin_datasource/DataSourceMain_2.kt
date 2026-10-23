package com.survivalcoding.kotlin_datasource

import com.survivalcoding.kotlin_datasource.data_source.FileItemDataSource
import com.survivalcoding.kotlin_datasource.data_source.ItemDataSource
import com.survivalcoding.kotlin_datasource.model.Item
import com.survivalcoding.kotlin_datasource.repository.ItemRepository
import com.survivalcoding.kotlin_datasource.repository.ItemRepositoryImpl

fun main() {
	val dataSource: ItemDataSource = FileItemDataSource()  // 나중엔 이 코드는 보이지 않게 될 거임
	val repository: ItemRepository = ItemRepositoryImpl(dataSource)  // dtype: interface
	
	repository.addItem(Item(1L, "기계식 키보드", 120_000))
	repository.addItem(Item(2L, "무선 마우스", 89_000))
	repository.addItem(Item(3L, "27인치 모니터", 350_000))
	
	println("=== 전체 아이템 목록 (이름순) ===")
	val allTimes = repository.getItems()
	allTimes.forEach { item ->
		println("- [ID : ${item.id}] ${item.name} (${item.price}원)")
	}
	
	println()
	println("=== 100,000원 이하 아이템 ===")
	val affordableItems = repository.getItemUnderPrice(100_000)
	affordableItems.forEach { item ->
		println("- ${item.name} : ${item.price}원")
	}
	
	println()
	println("=== ID 2L 아이템 조회 ===")
	val item = repository.getItem(2L)
	println("- 조회 결과 : $item")
	
}