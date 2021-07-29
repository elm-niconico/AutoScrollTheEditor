package scroller

import com.intellij.openapi.editor.ScrollingModel

interface IEditorScroller {
    /**
     * エディタをスクロールさせます
     * @return スクロール後のオフセット
     */
    fun scrollEditor(sm: ScrollingModel): Int
}
