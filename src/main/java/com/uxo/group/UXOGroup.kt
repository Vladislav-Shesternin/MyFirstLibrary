package com.uxo.group

import com.badlogic.gdx.scenes.scene2d.Group
import com.badlogic.gdx.graphics.g2d.Batch

class UXOGroup : Group() {

    fun initialize() {
        val vertexShaderStream = javaClass.classLoader.getResourceAsStream("shader/defaultVS.glsl")
        val fragmentShaderStream = javaClass.classLoader.getResourceAsStream("shader/maskFS.glsl")
    }


}