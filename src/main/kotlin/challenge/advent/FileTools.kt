package challenge.advent

class FileTools private constructor() {

    companion object {

        /**
         * Read the entirety of the resource at the given path.
         */
        fun readEntireFileFromResource(path: String): String {
            val reader = this::class.java.getResourceAsStream(path)!!.bufferedReader()
            val fileAsString = reader.readText()
            reader.close()

            return fileAsString;
        }
    }
}