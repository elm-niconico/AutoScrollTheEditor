package settingsState


import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBTextField
import com.intellij.util.ui.FormBuilder
import javax.swing.*

class SettingsComponent  {
    private var myMainPanel: JPanel? = null

    private val offsetSpinner = JSpinner(SpinnerNumberModel(1.0, 1.0, 15.0, 1.0))
    private val delaySpinner = JSpinner(SpinnerNumberModel(100.0, 1.0, 1000.0, 1.0))
    private val myUserNameText = JBTextField()

    init {
        myMainPanel = FormBuilder.createFormBuilder()
            .addLabeledComponent(JBLabel("SCROLL_OFFSET_Y"), offsetSpinner)
            .addLabeledComponent(JBLabel("SCROLL_DELAY"), delaySpinner)

            .addComponentFillVertically(JPanel(), 0)
            .panel
    }

    fun getPanel(): JPanel? {
        return myMainPanel
    }

    fun getPreferredFocusedComponent(): JComponent{
        return myUserNameText
    }

    fun getScrollOffsetY():Double {
        return offsetSpinner.value as Double
    }

    fun setScrollOffsetY(newText: Double) {
        offsetSpinner.value = newText
    }

    fun getScrollDelay(): Double {
        return delaySpinner.value as Double
    }

    fun setScrollDelay(delay: Double) {
        delaySpinner.value = delay
    }

}