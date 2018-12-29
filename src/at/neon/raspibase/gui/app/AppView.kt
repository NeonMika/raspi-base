package at.neon.raspibase.gui.app

import at.jku.mevss.trace.gui.utils.FXMLUtil.load
import at.neon.raspibase.gui.features.slideshow.SlideshowView
import javafx.fxml.FXML
import javafx.scene.control.TabPane
import javafx.scene.layout.BorderPane

class AppView : BorderPane() {
    @FXML
    lateinit var tabPane: TabPane

    init {
        load(AppView::class.java)

        val settings = SettingsView()
        tabPane.tabs += settings

        val slideshow = SlideshowView()
        settings.addFeature(slideshow)
        tabPane.tabs += slideshow
    }
}