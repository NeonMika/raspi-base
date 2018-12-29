package at.neon.raspibase.gui.features

interface Feature {
    data class Setting<T>(val name: String, private var value: T, val modifiable: Boolean = true) {
        private val listeners: MutableList<(T, T) -> Unit> = mutableListOf()

        fun set(value: T) {
            if (!modifiable) {
                throw IllegalStateException("Modifiable is set to false, thus Setting cannot be changed")
            }
            this.value = value
        }

        fun get(): T {
            return value
        }

        fun addListener(listener: (T, T) -> Unit) {
            listeners += listener
        }

        fun removeListener(listener: (T, T) -> Unit) {
            listeners -= listener
        }
    }

    val settings: List<Setting<*>>
}