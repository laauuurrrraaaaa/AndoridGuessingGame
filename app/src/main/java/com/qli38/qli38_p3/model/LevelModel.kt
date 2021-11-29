package com.qli38.qli38_p3.model

class LevelModel(level: String) {
    private var level: String

    init {
        this.level = level!!

    }
    fun getLevel(): String? {
        return level
    }
    fun setLevel(name: String?) {
        level = name!!
    }
}