# Adoption-Android
簡易動物領養瀏覽器，資料來自[農委會 OpenData](https://data.coa.gov.tw/Query/ServiceTransDetail.aspx?id=QcbUEzN6E6DL)

## 概要
- 主要頁面為`HomeFragment`，提供瀏覽領養動物的照片等資訊，手勢下滑可重新整理。API 每次抓取 20 筆資料，滑到底時觸發 loading more。
- 點擊 itemView 看詳細資訊，右上角 menu 有 filter 功能
- `DashbordFragment`, `NotificationFragment` 無用處，純粹保留空間給 `我的最愛頁面`
- `MainViewModel` 為 sharedViewModel，目前用來保存 filter

## 使用架構
MVVM with Repository Pattern

## 待完成功能
- `AnimalDetailFragment` 點擊地址資訊顯示地圖、點擊電話播號
- `AnimalDetailFragment` 為參數加上 label 並轉換參數文字，如 性別：母
- `AnimalDetailFragment` 提供更多資訊
- `AnimalDetailFragment` 點擊照片顯示完整圖片
- `AnimalFilterFragment` 加上『清除』按鈕
- 把文字都放到 `string.xml`
- [Optional] `AnimalFilterFragment` 研究 API 是否支援複選和 not 邏輯
- [Optional] `HomeFragment` 可切換為 Grid，只顯示照片並過濾掉沒有照片的動物
- [Optional] 刪除無用的 Fragment 並加入『我的最愛頁面』

## 已知 Issue

## Dependancy
- Navigation - Navigation for Fragments
- Koin - Dependency injection
- Retrofit - Restful API
- Coroutine - Asynchronous programming
- Glide - Image loader
- TagGroup - Layout of tags
