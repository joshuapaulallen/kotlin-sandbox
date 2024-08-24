package challenge.advent

class ListTools private constructor() {

    companion object {

        fun <T> split(list: List<T>, size: Int): List<List<T>> {
            val result = mutableListOf<List<T>>()
            for (i in 0 until list.size / size) {
                result.add(list.subList(i * size, (i + 1) * size))
            }
            return result
        }

    }

}