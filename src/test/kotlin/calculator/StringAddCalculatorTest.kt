package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class StringAddCalculatorTest {

    @Test
    fun `올바른 식을 입력하면 답을 반환해야 한다`() {
        // given
        val expression = "1,2:3"

        // when
        val result = StringAddCalculator.calculate(expression)

        // then
        assertThat(result).isEqualTo(6)
    }

    @Test
    fun `Null 값을 입력하면 0을 반환해야 한다`() {
        // given
        val expression = null

        // when
        val result = StringAddCalculator.calculate(expression)

        // then
        assertThat(result).isEqualTo(0)
    }

    @Test
    fun `빈 값을 입력하면 0을 반환해야 한다`() {
        // given
        val expression = "0"

        // when
        val result = StringAddCalculator.calculate(expression)

        // then
        assertThat(result).isEqualTo(0)
    }

    @Test
    fun `숫자 하나만 입력하면 해당 숫자를 반환해야 한다`() {
        // given
        val expression = "1"

        // when
        val result = StringAddCalculator.calculate(expression)

        // then
        assertThat(result).isEqualTo(1)
    }

    @Test
    fun `숫자 이외의 값을 입력하면 에러를 발생시켜야 한다`() {
        // given
        val expression = "abc,1,2"

        // when & then
        assertThatThrownBy { StringAddCalculator.calculate(expression) }
            .isInstanceOf(RuntimeException::class.java)
    }

    @Test
    fun `음수 값을 입력하면 에러를 발생시켜야 한다`() {
        // given
        val expression = "-1,1:2"

        // when & then
        assertThatThrownBy { StringAddCalculator.calculate(expression) }
            .isInstanceOf(RuntimeException::class.java)
    }

    @Test
    fun `커스텀 구분자를 지정할 수 있다`() {
        // given
        val expression = "//;\n1;2;3"

        // when
        val result = StringAddCalculator.calculate(expression)

        // then
        assertThat(result).isEqualTo(6)
    }

}
