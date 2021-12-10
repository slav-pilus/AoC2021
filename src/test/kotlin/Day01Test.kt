import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.spyk
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
        val day1Spy = spyk<Day01>()
        every { day1Spy.readInputFile()} returns input

        val countLarger = day1.countLarger(input)

        assertThat(countLarger).isEqualTo(0)
    }

    @Test
    fun countLagerShouldReturnZeroWhenSecondNumberIsSmaller() {
        val input = listOf(123, 12)
        val day1Spy = spyk<Day01>()
        every { day1Spy.readInputFile()} returns input

        val countLarger = day1.countLarger(input)

        assertThat(countLarger).isEqualTo(0)
    }

    @Test
    fun countLagerShouldReturnWhenSecondNumberIsLarger() {
        val input = listOf(123, 321)
        val day1Spy = spyk<Day01>()
        every { day1Spy.readInputFile()} returns input

        val countLarger = day1.countLarger(input)

        assertThat(countLarger).isEqualTo(1)
    }

    @Test
    fun countLagerShouldReturnHandleLargeDatasets() {
        val input = listOf(199, 200, 208, 210, 200, 207, 240, 269, 260, 263)
        val day1Spy = spyk<Day01>()
        every { day1Spy.readInputFile() } returns input

        val countLarger = day1.countLarger(input)

        assertThat(countLarger).isEqualTo(7)
    }

    @Test
    fun countLagerShouldReturnHandleEmptyList() {
        val input = emptyList<Int>()
        val day1Spy = spyk<Day01>()
        every { day1Spy.readInputFile()} returns input

        val countLarger = day1.countLarger(input)

        assertThat(countLarger).isEqualTo(0)
    }
}