import exceptions.CalculationException
import io.mockk.impl.annotations.InjectMockKs
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Day01Test {

    @InjectMockKs
    private val day1 = Day01()

    @Test
    fun dayOneShouldReadInputFile() {

        val inputFile = day1.readInputFile()

        assertThat(inputFile).isNotEmpty
    }

    @Test
    fun countLagerShouldReturnZeroForOneNumberInput() {
        val input = listOf(123)

        val countLarger = day1.countLarger(input)

        assertThat(countLarger).isEqualTo(0)
    }

    @Test
    fun countLagerShouldReturnZeroWhenSecondNumberIsSmaller() {
        val input = listOf(123, 12)

        val countLarger = day1.countLarger(input)

        assertThat(countLarger).isEqualTo(0)
    }

    @Test
    fun countLagerShouldReturnWhenSecondNumberIsLarger() {
        val input = listOf(123, 321)

        val countLarger = day1.countLarger(input)

        assertThat(countLarger).isEqualTo(1)
    }

    @Test
    fun countLagerShouldReturnHandleLargeDatasets() {
        val input = listOf(199, 200, 208, 210, 200, 207, 240, 269, 260, 263)

        val countLarger = day1.countLarger(input)

        assertThat(countLarger).isEqualTo(7)
    }

    @Test
    fun countLagerShouldReturnHandleEmptyList() {
        val input = emptyList<Int>()

        val countLarger = day1.countLarger(input)

        assertThat(countLarger).isEqualTo(0)
    }

    @Test
    fun sumNextThreeShouldReturnSumOfNextThreeElementsStartingFromIndex0() {
        val input = listOf(1, 1, 1)

        val countLarger = day1.sumNextThree(input, 0)

        assertThat(countLarger).isEqualTo(3)
    }

    @Test
    fun sumNextThreeShouldReturnSumOfNextThreeElementsStartingFromIndex1() {
        val input = listOf(1, 2, 2, 2)

        val countLarger = day1.sumNextThree(input, 1)

        assertThat(countLarger).isEqualTo(6)
    }

    @Test(expected = CalculationException::class)
    fun sumNextThreeShouldThrowExceptionWhenElementsNotPresent() {
        val input = listOf(1, 2)

        day1.sumNextThree(input, 1)
    }

    @Test
    fun countLargerGroupsShouldReturnZeroForSingleGroup() {
        val input = listOf(1, 2, 3)

        val count = day1.countGroups(input)

        assertThat(count).isEqualTo(0)
    }

    @Test
    fun countLargerGroupsShouldReturnOneWhenLargerGroupPresent() {
        val input = listOf(1, 2, 3, 4)

        val count = day1.countGroups(input)

        assertThat(count).isEqualTo(1)
    }

    @Test
    fun countLargerGroupsShouldReturnZeroWhenNoLargerGroupPresent() {
        val input = listOf(1, 2, 3, 0)

        val count = day1.countGroups(input)

        assertThat(count).isEqualTo(0)
    }

    @Test
    fun countLargerGroupsShouldWorkForLargeDataset() {
        val input = listOf(199, 200, 208, 210, 200, 207, 240, 269, 260, 263)

        val count = day1.countGroups(input)

        assertThat(count).isEqualTo(5)
    }
}