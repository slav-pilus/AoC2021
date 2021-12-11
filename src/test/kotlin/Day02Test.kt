import io.mockk.impl.annotations.InjectMockKs
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Day02Test {

    @InjectMockKs
    private val day2 = Day02()

    @Test
    fun dayTwoShouldReadInputFile() {

        val inputFile = day2.readInputFile()

        assertThat(inputFile).isNotEmpty
    }

    @Test
    fun calculateDepthShouldReturnDepthValue() {
        val input = listOf("down 5", "up 4")

        val depth = day2.calculateDepth(input)

        assertThat(depth).isEqualTo(1)
    }

    @Test
    fun calculateDepthShouldIgnoreHorizontalValues() {
        val input = listOf("forward 5", "down 5", "up 4")

        val depth = day2.calculateDepth(input)

        assertThat(depth).isEqualTo(1)
    }

    @Test
    fun calculateHorizontalShouldAddForwardValues() {
        val input = listOf("forward 5", "forward 4")

        val depth = day2.calculateHorizontal(input)

        assertThat(depth).isEqualTo(9)
    }

    @Test
    fun calculateHorizontalShouldIgnoreDepthValues() {
        val input = listOf("up 2", "forward 5", "forward 4")

        val depth = day2.calculateHorizontal(input)

        assertThat(depth).isEqualTo(9)
    }

}