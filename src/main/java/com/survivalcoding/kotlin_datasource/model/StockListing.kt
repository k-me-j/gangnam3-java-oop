package com.survivalcoding.kotlin_datasource.model

data class StockListing(
	val symbol: String,     // 티커 심볼 ex. AAPL
	val name: String,       // 회사명 ex. Apple Inc
	val exchange: String,   // 거래소 ex. NASDAQ, NYSE
	val assetType: String,  // 자산 종류 ex. Stock, ETF
	val ipoDate: String,    // 상장일 ex. 1980-12-12
	val status: String,     // 상태 ex. Active
)

// 기존 클래스에 넣은 것처럼 확장 함수 만드는 걸 추천
// 데이터 클래스는 순수하게 둘 것 : 데이터 클래스에 함수 추가하지 말고