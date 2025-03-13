package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
    @Test
    @DisplayName("null 경우, 0을 반환한다.")
    public void calculate_NullTest() {
        int result = StringAddCalculator.Calculate(null);
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("빈문자인 경우, 0을 반환한다.")
    public void calculate_BlankTest() {
        int result = StringAddCalculator.Calculate("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("음수인 경우, RuntimeException 예외를 throw 한다.")
    public void calculate_NegativeTest() {
        assertThatThrownBy(() -> StringAddCalculator.Calculate("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("숫자 이외 값이 들어간 경우, RuntimeException 예외를 throw 한다.")
    public void calculate_NotNumberTest() {
        assertThatThrownBy(() -> StringAddCalculator.Calculate("zz,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("숫자 하나인 경우, 해당 숫자를 반환한다.")
    public void calculate_OneNumberTest() {
        int result = StringAddCalculator.Calculate("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("쉼표로 구분된 숫자의 합을 반환한다.")
    public void calcalate_comaTest() {
        int result = StringAddCalculator.Calculate("4,5");
        assertThat(result).isEqualTo(9);
    }

    @Test
    @DisplayName("콜론으로 구분된 숫자의 합을 반환한다.")
    public void calcalate_ColonTest() {
        int result = StringAddCalculator.Calculate("1:2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("쉼표 또는 콜론으로 구분된 숫자의 합을 반환한다.")
    public void calcalate_comaOrColonTest() {
        int result = StringAddCalculator.Calculate("1,2:9");
        assertThat(result).isEqualTo(12);
    }

    @Test
    @DisplayName("커스텀 구분자로 숫자의 합을 반환한다.")
    public void calcalate_customDelimiterTest() {
        int result = StringAddCalculator.Calculate("//?\n1?2?3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("쉼표 또는 콜론 또는 커스텀 구분자로 숫자의 합을 반환한다.")
    public void calcalate_comaOrColonOrcustomDelimiterTest() {
        int result = StringAddCalculator.Calculate("//?\n1?2:3,4");
        assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("쉼표 또는 콜론 또는 커스텀 구분자가 아닌 구분자가 들어갈 경우, RuntimeException 예외를 throw 한다.")
    public void calcalate_elseDelimiterTest() {
        assertThatThrownBy(() -> StringAddCalculator.Calculate("//?\n1?2:3,4;5"))
                .isInstanceOf(RuntimeException.class);
    }
}