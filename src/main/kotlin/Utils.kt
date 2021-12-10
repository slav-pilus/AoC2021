import java.io.File

class Utils {
    companion object FileUtils {
        fun readFileToList(fileName: String): List<String> {
            val lineList = mutableListOf<String>()

            this::class.java.getResource(fileName).openStream().bufferedReader().forEachLine { lineList.add(it) }

            return lineList
        }

        fun readFileToIntList(fileName: String): List<Int> {
            val lineList = mutableListOf<Int>()

            this::class.java.getResource(fileName).openStream().bufferedReader().forEachLine { lineList.add(Integer.parseInt(it)) }

            return lineList
        }
    }
}