import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.editor.Editor
import timerjob.EditorScrollJob
import java.awt.event.ActionEvent
import java.util.*
import javax.swing.Timer

class EditorAction : AnAction() {
    private val timerJob = EditorScrollJob()
    private var editor: Editor? = null
    override fun actionPerformed(e: AnActionEvent) {
        val editor = e.getData(CommonDataKeys.EDITOR)
        if(editor === null) return

        if(this.editor !== null && this.editor == editor){
            if(timerJob.isRunning()) timerJob.stop()
            else timerJob.start(editor)
        }else{
            this.editor = editor
            timerJob.stop()
            timerJob.start(editor)
        }

    }

}