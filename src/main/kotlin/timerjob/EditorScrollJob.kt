package timerjob

import com.intellij.openapi.editor.Editor
import scroller.SimpleEditorScroller
import settingsState.SettingsState
import javax.swing.Timer


class EditorScrollJob() : ITimerJob {
    private val config = SettingsState.SettingState.getInstance()
    private val timer = Timer(config.scrollDelay.toInt(),null)
    private lateinit var actionEvent: Editor

    init {
        timer.isRepeats = true
    }

    override fun isRunning(): Boolean {
        return timer.isRunning
    }

    override fun start(editor:Editor) {
        actionEvent = editor
        timer.addActionListener{scrollJob(actionEvent)}
        timer.start()
    }

    override fun stop() {

        timer.removeActionListener{ scrollJob(actionEvent)}
        timer.stop()
    }

    private fun scrollJob(editor : Editor){

        val sm = editor.scrollingModel
        val beforeScrollOffsetY = sm.verticalScrollOffset
        val scroller = SimpleEditorScroller(config.scrollOffsetY.toInt())
        val afterScrollOffsetY = scroller.scrollEditor(sm)

        if ( afterScrollOffsetY <= beforeScrollOffsetY ) {
            println(timer.actionListeners.size)

            timer.stop()
        }
    }
}