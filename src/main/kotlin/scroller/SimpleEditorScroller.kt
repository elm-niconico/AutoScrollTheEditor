package scroller

import com.intellij.openapi.editor.ScrollingModel

class SimpleEditorScroller(private val scrollOffset: Int): IEditorScroller{
    override fun scrollEditor(sm: ScrollingModel): Int {
        sm.scrollVertically(sm.verticalScrollOffset + scrollOffset)
        return sm.verticalScrollOffset
    }

}