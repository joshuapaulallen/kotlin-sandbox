package challenge.advent

class StringTools private constructor() {

    companion object {

        /**
         * Splits a string into segments of equal length.
         */
        fun splitString(str: String, numSegments: Int): List<String> {
            if (str.length % numSegments != 0) throw IllegalArgumentException("Unable to split string evenly into $numSegments segments")

            val segmentLength = str.length / numSegments
            val strList = mutableListOf<String>()
            for (i in 0 until numSegments) {
                strList.add(str.substring(i * segmentLength, (i + 1) * segmentLength))
            }

            return strList
        }
    }
}