package com.uxo.group

import com.badlogic.gdx.scenes.scene2d.Group

class UXOGroup : Group() {

    fun internalFun(): String {
        val s = javaClass.getResource("/shader/defaultVS.glsl")?.readText() ?: throw IllegalStateException("Shader not found")
        return s
    }
    
}

fun globalFun(): String {
    val s = object {}.javaClass.getResource("/shader/defaultVS.glsl")?.readText() ?: throw IllegalStateException("Shader not found")
    return s
}