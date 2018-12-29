package at.neon.raspibase.gui.app

import at.jku.mevss.trace.gui.utils.FXMLUtil.load
import at.neon.raspibase.gui.features.Feature
import javafx.fxml.FXML
import javafx.scene.Node
import javafx.scene.control.Tab
import javafx.scene.control.TableView

class SettingsView : Tab("Settings") {
    @FXML
    lateinit var table: TableView<Feature.Setting<*>>

    private val features = mutableSetOf<Feature>()

    init {
        load(SettingsView::class.java)
    }

    public fun addFeature(feature: Feature) {
        if (features.add(feature)) {
            table.items.addAll(feature.settings)
        }
    }

    public fun removeFeature(feature: Feature) {
        if (features.remove(feature)) {
            table.items.clear()
            table.items.addAll(features.flatMap { it.settings })
        }
    }
}