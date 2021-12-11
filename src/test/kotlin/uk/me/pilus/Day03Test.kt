package uk.me.pilus

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test


class Day03Test {

    private val target = Day03()

    @Test
    fun extractColumnShouldExtractColumnFromInput() {
        val input = listOf("1", "1")

        val result = target.extractColumn(0, input);

        assertThat(result).hasSize(2)
        assertThat(result).containsExactly(1, 1)
    }

    @Test
    fun getHighestBitForColumnShouldReturnHighestBit() {
        val input = listOf("1", "1")

        val highestBitForColumn = target.getHighestBitForColumn(0, input)

        assertThat(highestBitForColumn).isEqualTo(1)
    }

    @Test
    fun getHighestBitForColumnShouldReturnHighestBitForZeros() {
        val input = listOf("0", "0")

        val highestBitForColumn = target.getHighestBitForColumn(0, input)

        assertThat(highestBitForColumn).isEqualTo(0)
    }

    @Test
    fun getHighestBitForColumnShouldReturnHighestBitWithMixedInput() {
        val input = listOf("1", "1", "0")

        val highestBitForColumn = target.getHighestBitForColumn(0, input)

        assertThat(highestBitForColumn).isEqualTo(1)
    }

    @Test
    fun getHighestBitForColumnShouldReturnHighestBitWithMixedInputWithZerosLarger() {
        val input = listOf("1", "0", "0")

        val highestBitForColumn = target.getHighestBitForColumn(0, input)

        assertThat(highestBitForColumn).isEqualTo(0)
    }

    @Test
    fun getHighestBitForColumnShouldReturnHighestBitWithMixedInputWithZerosLargerMulticolumn() {
        val input = listOf("10", "00", "00")

        val highestBitForColumn = target.getHighestBitForColumn(0, input)

        assertThat(highestBitForColumn).isEqualTo(0)
    }

    @Test
    fun reverseBinaryShouldReverseBinaryString() {
        val result = target.reverseBinary("000111000")

        assertThat(result).isEqualTo("111000111")
    }
}