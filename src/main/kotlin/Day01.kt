import exceptions.CalculationException

private const val GROUP_SIZE = 3

class Day01 {

    fun solvePart1(): Int {
        return countLarger(readInputFile())
    }

    fun solvePart2(): Int {
        return countGroups(readInputFile())
    }

    fun readInputFile(): List<Int> {
        return Utils.readFileToIntList("day1.txt")
    }

    fun countLarger(input: List<Int>): Int {
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

    fun countGroups(input: List<Int>): Int {
        var count = 0
        var previous = 0
        if (input.size == GROUP_SIZE)
            return 0

        input.forEachIndexed { index, _ ->
            if (index + GROUP_SIZE <= input.size) {
                val nextGroupSum = sumNextThree(input, index)
                if (index != 0 && nextGroupSum > previous) {
                    count++
                }
                previous = nextGroupSum
            }
        }
        return count
    }

    fun sumNextThree(input: List<Int>, i: Int): Int {
        var sum = 0
        input.forEachIndexed { index, element ->
            if (i == index) {
                try {
                    sum = element + input[i + 1] + input[i + 2]
                } catch (e: ArrayIndexOutOfBoundsException) {
                    throw CalculationException("Incorrect index or end of elements")
                }
            }
        }
        return sum
    }
}