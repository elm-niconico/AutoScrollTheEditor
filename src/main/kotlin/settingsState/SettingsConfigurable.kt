package settingsState

import com.intellij.openapi.options.Configurable
import org.jetbrains.annotations.Nls
import javax.swing.JComponent

class SettingsConfigurable : Configurable{
    private var mySettingsComponent: SettingsComponent? = null

    override fun createComponent(): JComponent? {
        mySettingsComponent = SettingsComponent()
        return mySettingsComponent?.getPanel()
    }

    override fun getDisplayName(): @Nls(capitalization = Nls.Capitalization.Title) String {
        return "AutoScrollTheEditor"
    }

    override fun getPreferredFocusedComponent(): JComponent? {
        return mySettingsComponent?.getPreferredFocusedComponent()
    }



    override fun isModified(): Boolean {
        val settings = SettingsState.SettingState.getInstance()
        var modified = (mySettingsComponent?.getScrollOffsetY() != settings.scrollOffsetY)
        modified = modified or (mySettingsComponent?.getScrollDelay() != settings.scrollDelay)
        return modified
    }

    override fun apply() {
        val settings = SettingsState.SettingState.getInstance()
        settings.scrollOffsetY = mySettingsComponent?.getScrollOffsetY() ?: 1.0
        settings.scrollDelay = mySettingsComponent?.getScrollDelay() ?: 100.0
    }

    override fun reset() {
        val settings = SettingsState.SettingState.getInstance()
        mySettingsComponent?.setScrollOffsetY(settings.scrollOffsetY)
        mySettingsComponent?.setScrollDelay(settings.scrollDelay)
    }

    override fun disposeUIResources() {
        mySettingsComponent = null
    }

}