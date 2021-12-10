class Day01 {

    fun solve(): Int {
        return countLarger(readInputFile())
    }

    fun readInputFile(): List<Int> {
        return Utils.readFileToIntList("day1.txt")
    }

    fun countLarger(input: List<Int>) :Int {
        var largerCount = 0
        var previous = 0
        input.forEachIndexed { index, element ->
            previous = if (index == 0) {
                element
            } else {
                if (element > previous) {
                    largerCount++
                }
                element
            }
        }
      return largerCount
    }
}