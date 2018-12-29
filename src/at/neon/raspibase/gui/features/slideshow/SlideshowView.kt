package at.neon.raspibase.gui.features.slideshow

import at.jku.mevss.trace.gui.utils.FXMLUtil.load
import at.neon.raspibase.gui.features.Feature
import javafx.fxml.FXML
import javafx.scene.control.Tab
import javafx.scene.image.ImageView

class SlideshowView() : Tab("Slideshow"), Feature {
    @FXML
    lateinit var imageView: ImageView

    val timeBetweenImagesSetting = Feature.Setting<Int>("Time between images", 10)
    val pathSetting = Feature.Setting<String>("Path", "")

    init {
        load(SlideshowView::class.java)
    }

    override val settings: List<Feature.Setting<*>> = listOf(
            timeBetweenImagesSetting,
            pathSetting
    )
}