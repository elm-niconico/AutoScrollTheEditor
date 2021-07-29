package timerjob

import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.editor.Editor

interface ITimerJob {
    fun isRunning(): Boolean

    fun stop()
    fun start(editor : Editor)
}