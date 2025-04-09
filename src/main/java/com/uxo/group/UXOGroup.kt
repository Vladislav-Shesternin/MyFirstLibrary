package com.uxo.group

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.scenes.scene2d.Group
import com.badlogic.gdx.graphics.g2d.Batch

class UXOGroup : Group() {

//    fun initialize() {
//        val vertexShaderStream = javaClass.classLoader.getResourceAsStream("shader/defaultVS.glsl")
//        val fragmentShaderStream = javaClass.classLoader.getResourceAsStream("shader/maskFS.glsl")
//    }

    fun a1(): String {
        val s = object {}.javaClass.getResource("shader/defaultVS.glsl")?.readText() ?: throw IllegalStateException("Shader not found")
        return s
    }

    fun a2(): String {
        val s = javaClass.getResource("shader/defaultVS.glsl")?.readText() ?: throw IllegalStateException("Shader not found")
        return s
    }

    fun a3(): String {
        val s = object {}.javaClass.getResource("/shader/defaultVS.glsl")?.readText() ?: throw IllegalStateException("Shader not found")
        return s
    }

    fun a4(): String {
        val s = javaClass.getResource("/shader/defaultVS.glsl")?.readText() ?: throw IllegalStateException("Shader not found")
        return s
    }


}