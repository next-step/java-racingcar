package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
    @Test
    @DisplayName("null 경우, 0을 반환한다.")
    public void calculate_NullTest() {
        int result = StringAddCalculator.calculate(null);
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("빈문자인 경우, 0을 반환한다.")
    public void calculate_BlankTest() {
        int result = StringAddCalculator.calculate("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("음수인 경우, RuntimeException 예외를 throw 한다.")
    public void calculate_NegativeTest() {
        assertThatThrownBy(() -> StringAddCalculator.calculate("-1,2,3"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("음수는 입력할 수 없습니다. 입력값: -1");
    }

    @Test
    @DisplayName("숫자 이외 값이 들어간 경우, RuntimeException 예외를 throw 한다.")
    public void calculate_NotNumberTest() {
        assertThatThrownBy(() -> StringAddCalculator.calculate("zz,2,3"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("숫자가 아닌 값이 포함되어 있습니다. 입력값: zz");
    }

    @Test
    @DisplayName("숫자 하나인 경우, 해당 숫자를 반환한다.")
    public void calculate_OneNumberTest() {
        int result = StringAddCalculator.calculate("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("쉼표로 구분된 숫자의 합을 반환한다.")
    public void calcalate_comaTest() {
        int result = StringAddCalculator.calculate("4,5");
        assertThat(result).isEqualTo(9);
    }

    @Test
    @DisplayName("콜론으로 구분된 숫자의 합을 반환한다.")
    public void calcalate_ColonTest() {
        int result = StringAddCalculator.calculate("1:2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("쉼표 또는 콜론으로 구분된 숫자의 합을 반환한다.")
    public void calcalate_comaOrColonTest() {
        int result = StringAddCalculator.calculate("1,2:9");
        assertThat(result).isEqualTo(12);
    }

    @Test
    @DisplayName("커스텀 구분자로 숫자의 합을 반환한다.")
    public void calcalate_customDelimiterTest() {
        int result = StringAddCalculator.calculate("//?\n1?2?3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자가 아닌 구분자가 들어갈 경우, RuntimeException 예외를 throw 한다.")
    public void calcalate_elseDelimiterTest() {
        assertThatThrownBy(() -> StringAddCalculator.calculate("//?\n1?2:3,4;5"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("숫자가 아닌 값이 포함되어 있습니다. 입력값: 2:3,4;5");
    }
}