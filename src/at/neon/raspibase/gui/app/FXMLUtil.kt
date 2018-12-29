package at.jku.mevss.trace.gui.utils

import at.neon.raspibase.gui.app.AppView
import javafx.fxml.FXMLLoader
import javafx.scene.Node
import javafx.scene.Parent
import javafx.scene.control.DialogPane
import java.io.IOException
import java.util.logging.Logger

object FXMLUtil {
    internal var LOGGER = Logger.getLogger(FXMLUtil::class.java.name)
    internal var mainCSS: Class<*> = AppView::class.java

    fun Any.load(klass: Class<*>) {
        if (DialogPane::class.java.isAssignableFrom(klass)) {
            loadCSS(mainCSS)
        }

        loadCSS(klass)

        val fxmlFile = klass.getResource(klass.simpleName + ".fxml")
        val fxmlLoader = FXMLLoader(fxmlFile)
        fxmlLoader.setController(this)
        fxmlLoader.setRoot(this)

        try {
            fxmlLoader.load<Any>()
        } catch (exception: IOException) {
            throw RuntimeException(exception)
        }
    }

    private fun Any.loadCSS(klass: Class<*>) {
        klass.getResource(klass.simpleName + ".css")?.let { value ->
            if (this is Parent) {
                stylesheets.add(value.toExternalForm())
            }
        }
    }
}
