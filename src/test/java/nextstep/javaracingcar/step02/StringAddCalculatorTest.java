package nextstep.javaracingcar.step02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static nextstep.calculator.PositiveNumber.from;
import static nextstep.calculator.StringAddCalculator.calculate;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @DisplayName("빈 문자열 또는 null 또는 공백을 입력할 경우 0을 반환한다.")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  ", "   ", "     "})
    public void spec01(final String input) {
        assertThat(calculate(input)).isEqualTo(from(0));
    }

    @DisplayName("1개의 숫자만 입력시 해당 숫자를 반환한다.")
    @Test
    public void spec02() {
        assertThat(calculate("1")).isEqualTo(from(1));
        assertThat(calculate("2")).isEqualTo(from(2));
        assertThat(calculate("10")).isEqualTo(from(10));
    }

    @DisplayName("콤마(,)로 문자열을 구분하여 더하기를 한다. (예 : '1,2,3' => 6)")
    @Test
    public void spec03() {
        assertThat(calculate("1,2,3")).isEqualTo(from(6));
        assertThat(calculate("5,5,5")).isEqualTo(from(15));
        assertThat(calculate("30,20,10")).isEqualTo(from(60));
    }

    @DisplayName("콜론(:)으로 문자열을 구분하여 더하기를 한다. (예 : '1:2:3' => 6)")
    @Test
    public void spec04() {
        assertThat(calculate("1:2:3")).isEqualTo(from(6));
        assertThat(calculate("7:7:7")).isEqualTo(from(21));
        assertThat(calculate("30:20:10")).isEqualTo(from(60));
    }

    @DisplayName("음수일 경우 runtime exception 을 발생한다.")
    @Test
    public void spec05() {
        assertThatThrownBy(() -> calculate("1,2:-3,4:-5")).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("숫자가 아닐 경우 runtime exception 을 발생한다.")
    @Test
    public void spec06() {
        assertThatThrownBy(() -> calculate("a,2:-3,c:-5")).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("\"//\"와 \"\n\" 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : \"//;\n1;2;3\" => 6)")
    @Test
    public void spec07() {
        assertThat(calculate("//;\n1;2;3")).isEqualTo(from(6));
        assertThat(calculate("//#\n7#8#9")).isEqualTo(from(24));
    }
}
