class Day02 {

    data class Measurements(val horizontal: Int, val depth: Int)


    fun solvePart1(): Int {
        return calculateDepth(readInputFile()) * calculateHorizontal(readInputFile())
    }

    fun solvePart2(): Int {
        val measurements = getMeasurements(readInputFile())
        return measurements.horizontal * measurements.depth
    }

    fun getMeasurements(input: List<String>): Measurements {
        var horizontal = 0
        var depth = 0
        var aim = 0
        input.forEach {
            val currentValue = Integer.parseInt(it.split(" ")[1])
            if (it.startsWith("forward")) {
                horizontal += currentValue
                depth += aim * currentValue
            }
            if (it.startsWith("up")) {
                aim -= currentValue
            }
            if (it.startsWith("down")) {
                aim += currentValue
            }
        }

        return Measurements(horizontal, depth)
    }

    fun calculateHorizontal(input: List<String>): Int {
        return input.filter { it.startsWith("forward") }
            .sumOf { Integer.parseInt(it.split(" ")[1]) }
    }

    fun calculateDepth(input: List<String>): Int {
        val downSum = input.filter { it.startsWith("down") }
            .sumOf { Integer.parseInt(it.split(" ")[1]) }
        val upSum = input.filter { it.startsWith("up") }
            .sumOf { Integer.parseInt(it.split(" ")[1]) }
        return downSum - upSum
    }

    fun readInputFile(): List<String> {
        return Utils.readFileToList("day2.txt")
    }


}