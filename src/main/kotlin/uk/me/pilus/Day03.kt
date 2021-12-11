package uk.me.pilus

class Day03 {
    fun solve(): Int {
        val input = readInputFile()
        var gamma = ""

        for (i in (input[0].indices)) {
            gamma += getHighestBitForColumn(i, input)
        }

        val gammaDecimal = Integer.parseInt(gamma, 2)
        val epsilon = Integer.parseInt(reverseBinary(gamma), 2)

        return gammaDecimal * epsilon
    }

    fun reverseBinary(gamma: String): String {
        var reverse = ""
        gamma.forEach {
            reverse += if (it == '0') {
                "1"
            } else {
                "0"
            }
        }
        return reverse

    }


    fun getHighestBitForColumn(column: Int, input: List<String>): Int {
        val extractColumn = extractColumn(column, input)
        val sum = extractColumn.sum()

        return if (sum > extractColumn.size / 2) {
            1
        } else {
            0
        }
    }

    fun extractColumn(i: Int, input: List<String>): MutableList<Int> {
        val column = mutableListOf<Int>()

        input.forEach {
            column.add(Integer.parseInt(it.elementAt(i).toString()))
        }

        return column
    }

    fun readInputFile(): List<String> {
        return Utils.readFileToList("/day3.txt")
    }
}