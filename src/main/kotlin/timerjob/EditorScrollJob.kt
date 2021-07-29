package timerjob

import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.editor.CaretActionListener
import com.intellij.openapi.editor.Editor
import scroller.SimpleEditorScroller
import javax.swing.Timer


class EditorScrollJob() : ITimerJob {
    private val timer = Timer(100,null)
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
        val scroller = SimpleEditorScroller(1)
        val afterScrollOffsetY = scroller.scrollEditor(sm)

        if ( afterScrollOffsetY <= beforeScrollOffsetY ) {
            println(timer.actionListeners.size)
            println("END")
            timer.stop()
        }
    }
}