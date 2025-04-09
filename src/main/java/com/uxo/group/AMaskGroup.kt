//package com.uxo.group
//
//import com.badlogic.gdx.Gdx
//import com.badlogic.gdx.graphics.*
//import com.badlogic.gdx.graphics.g2d.Batch
//import com.badlogic.gdx.graphics.g2d.TextureRegion
//import com.badlogic.gdx.graphics.glutils.FrameBuffer
//import com.badlogic.gdx.graphics.glutils.ShaderProgram
//import com.badlogic.gdx.math.Vector2
//import com.badlogic.gdx.scenes.scene2d.Actor
//import com.badlogic.gdx.utils.ScreenUtils
//import com.badlogic.gdx.utils.viewport.Viewport
//import com.rayscaya.nasjajdenye.game.utils.advanced.AdvancedGroup
//import com.rayscaya.nasjajdenye.game.utils.advanced.AdvancedScreen
//import com.rayscaya.nasjajdenye.game.utils.disposeAll
//
//class AMaskGroup(
//    override val screen: AdvancedScreen,
//    private val maskTexture: Texture = screen.drawerUtil.getTexture(Color.BLACK),
//): AdvancedGroup() {
//
//    companion object {
//        private var vertexShader   = Gdx.files.internal("shader/defaultVS.glsl").readString()
//        private var fragmentShader = Gdx.files.internal("shader/maskFS.glsl").readString()
//    }
//
//    private var shaderProgram: ShaderProgram? = null
//
//    private var fboGroup    : FrameBuffer?   = null
//    private var textureGroup: TextureRegion? = null
//
//    private var camera = OrthographicCamera()
//
//    private var screenXInPixels      = 0
//    private var screenYInPixels      = 0
//    private var screenWidthInPixels  = 0
//    private var screenHeightInPixels = 0
//    private var screenWidthInWorld   = 0f
//    private var screenHeightInWorld  = 0f
//
//    private val globalPosition = Vector2()
//    private val tmpVector2     = Vector2(0f, 0f)
//
//    override fun addActorsOnGroup() {
//        createShaders()
//        createFrameBuffer()
//    }
//
//    override fun draw(batch: Batch?, parentAlpha: Float) {
//        if (batch         == null ||
//            shaderProgram == null ||
//            fboGroup      == null
//        ) return
//
//        batch.end()
//
//        globalPosition.set(Actor.localToStageCoordinates(tmpVector2.set(0f, 0f)))
//        camera.position.set(
//            globalPosition.x + Actor.getWidth / 2f,
//            globalPosition.y + Actor.getHeight / 2f,
//            0f
//        )
//        camera.update()
//
//        saveViewportSize()
//
//        // draw fboGroup -------------------------------
//
//        //SpriteBatch().setBlendFunction()
//        //batch.setBlendFunction(GL20.GL_ONE, GL20.GL_ONE_MINUS_SRC_ALPHA)
//        //batch.setBlendFunction(GL20.GL_ONE_MINUS_DST_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA)
//        //batch.setBlendFunctionSeparate(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA, GL20.GL_SRC_ALPHA, GL20.GL_ONE)
//
//        fboGroup!!.begin()
//        ScreenUtils.clear(Color.CLEAR)
//        batch.begin()
//        batch.projectionMatrix = camera.combined
//
//        batch.setBlendFunction(GL20.GL_ONE_MINUS_DST_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA)
//        super.draw(batch, parentAlpha)
//
//        batch.setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA)
//        batch.color = Color.WHITE
//
//        batch.projectionMatrix = Actor.getStage.camera.combined
//
//        batch.end()
//        fboGroup!!.end(screenXInPixels, screenYInPixels, screenWidthInPixels, screenHeightInPixels)
//
//        // draw Result -------------------------------
//
//        batch.begin()
//
//        batch.shader = shaderProgram
//
//        Gdx.gl.glActiveTexture(GL20.GL_TEXTURE1)
//        maskTexture.bind(1)
//        Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0)
//        textureGroup!!.texture.bind(0)
//
//        shaderProgram!!.setUniformi("u_mask", 1)
//        shaderProgram!!.setUniformi("u_texture", 0)
//
//        batch.draw(
//            textureGroup,
//            Actor.getX, Actor.getY,
//            Actor.getOriginX, Actor.getOriginY,
//            Actor.getWidth, Actor.getHeight,
//            Actor.getScaleX, Actor.getScaleY,
//            Actor.getRotation,
//        )
//
//        batch.shader = null
//
//        batch.end()
//
//        batch.begin()
//    }
//
//    override fun dispose() {
//        super.dispose()
//        disposeAll(
//            shaderProgram,
//            fboGroup,
//        )
//    }
//
//    // Logic ------------------------------------------------------------------------
//
//    private fun createShaders() {
//        ShaderProgram.pedantic = false
//        shaderProgram = ShaderProgram(vertexShader, fragmentShader)
//
//        if (shaderProgram?.isCompiled == false) {
//            throw IllegalStateException("shader compilation failed:\n" + shaderProgram?.log)
//        }
//    }
//
//    private fun createFrameBuffer() {
//        //camera = OrthographicCamera(width, height)
//        //camera.setToOrtho(false, width, height)
//
//        camera = OrthographicCamera(Actor.getWidth, Actor.getHeight)
//        camera.position.set(Actor.getX + (Actor.getWidth / 2f), Actor.getY + (Actor.getHeight / 2f), 0f)
//        camera.update()
//
//        fboGroup = FrameBuffer(Pixmap.Format.RGBA8888, Actor.getWidth.toInt(), Actor.getHeight.toInt(), false)
//
//        textureGroup = TextureRegion(fboGroup!!.colorBufferTexture)
//        textureGroup!!.flip(false, true)
//    }
//
//    private fun saveViewportSize() {
//        Actor.getStage.viewport.apply {
//            screenXInPixels      = Viewport.getScreenX
//            screenYInPixels      = Viewport.getScreenY
//            screenWidthInPixels  = Viewport.getScreenWidth
//            screenHeightInPixels = Viewport.getScreenHeight
//            screenWidthInWorld   = Viewport.getWorldWidth
//            screenHeightInWorld  = Viewport.getWorldHeight
//        }
//    }
//
//}