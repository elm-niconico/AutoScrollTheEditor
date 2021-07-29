package settingsState

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage

import com.intellij.util.xmlb.XmlSerializerUtil
/**
 * Supports storing the application settings in a persistent way.
 * The {@link State} and {@link Storage} annotations define the name of the data and the file name where
 * these persistent application settings are stored.
 */
@State(name = "org.intellij.sdk.settings.AppSettingsState", storages = [Storage("SdkSettingsPlugin.xml")])
class SettingsState : PersistentStateComponent<SettingsState> {
    var scrollOffsetY = 1.0
    var scrollDelay = 100.0

    object SettingState{
        fun getInstance(): SettingsState {

            return ApplicationManager.getApplication().getService(SettingsState::class.java)
        }
    }



    override fun getState(): SettingsState {
        return this
    }

    override fun loadState(state: SettingsState) {
        XmlSerializerUtil.copyBean(state, this)
    }

}