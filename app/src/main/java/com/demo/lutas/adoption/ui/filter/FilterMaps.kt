package com.demo.lutas.adoption.ui.filter


class FilterMaps {
    val kindMap = mapOf<String, String>(
        "貓" to "貓",
        "狗" to "狗"
    )
    val kindKeys
        get() = kindMap.keys.toList()
    val sexMap = mapOf<String, String>(
        "公" to "M",
        "母" to "F"
    )
    val sexKeys
        get() = sexMap.keys.toList()
    val sterilizationMap = mapOf<String, String>(
        "已節育" to "T",
        "未節育" to "F"
    )
    val sterilizationKeys
        get() = sterilizationMap.keys.toList()
    val ageMap = mapOf<String, String>(
        "幼年" to "CHILD",
        "成年" to "ADULT"
    )
    val ageKeys
        get() = ageMap.keys.toList()
    val bodyTypeMap = mapOf<String, String>(
        "小型" to "SMALL",
        "中型" to "MEDIUM",
        "大型" to "BIG"
    )
    val bodyTypeKeys
        get() = bodyTypeMap.keys.toList()
    val areaMap = mapOf(
        "臺北市" to 2,
        "新北市" to 3,
        "基隆市" to 4,
        "宜蘭縣" to 5,
        "桃園縣" to 6,
        "新竹縣" to 7,
        "新竹市" to 8,
        "苗栗縣" to 9,
        "臺中市" to 10,
        "彰化縣" to 11,
        "南投縣" to 12,
        "雲林縣" to 13,
        "嘉義縣" to 14,
        "嘉義市" to 15,
        "臺南市" to 16,
        "高雄市" to 17,
        "屏東縣" to 18,
        "花蓮縣" to 19,
        "臺東縣" to 20,
        "澎湖縣" to 21,
        "金門縣" to 22,
        "連江縣" to 23
    )
    val areaKeys
        get() = areaMap.keys.toList()
}