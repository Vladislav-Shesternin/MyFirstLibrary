package com.uxo.group

import com.badlogic.gdx.scenes.scene2d.Group
import com.badlogic.gdx.graphics.g2d.Batch

class UXOGroup : Group() {

    init {
        // Ініціалізація, якщо потрібно
    }

    override fun act(delta: Float) {
        super.act(delta)
        // Твоя логіка тут
    }

    override fun draw(batch: Batch?, parentAlpha: Float) {
        super.draw(batch, parentAlpha)
        // Малювання кастомних ефектів, якщо треба
    }
}