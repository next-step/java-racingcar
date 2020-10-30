package secondStage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {

    @DisplayName(value = "문자열을 사칙연산 한다.")
    @Test
    void addAndSubtract() {
        // given
        String source = "2 + 3 * 4 / 2";

        // when
        int result = StringCalculator.calculator(source);

        // then
        assertThat(result).isEqualTo(10);
    }

    @DisplayName(value = "문자열 중 연산자만 추출한다.")
    @Test
    void createOperands() {
        // given
        String[] source = "2 + 3 * 4 / 2".split(" ");

        // when
        List<Integer> result = StringCalculator.createOperands(source);

        // then
        assertThat(result.get(0)).isEqualTo(2);
        assertThat(result.get(1)).isEqualTo(3);
        assertThat(result.get(2)).isEqualTo(4);
        assertThat(result.get(3)).isEqualTo(2);
    }

    @DisplayName(value = "문자열 중 피연산자만 추출한다.")
    @Test
    void createOperators() {
        // given
        String[] source = "2 + 3 * 4 / 2".split(" ");

        // when
        List<String> result = StringCalculator.createOperators(source);

        // then
        assertThat(result.get(0)).isEqualTo("+");
        assertThat(result.get(1)).isEqualTo("*");
        assertThat(result.get(2)).isEqualTo("/");
    }

    @DisplayName(value = "문자열을 배열로 변환한다.")
    @Test
    void split() {
        // given
        String source = "1 + 2";

        // when
        String[] result = StringCalculator.split(source);

        // then
        assertThat(result.length).isEqualTo(3);
    }

    @DisplayName(value = "null or empty IllegalArgumentException")
    @Test
    void validateNone() {
        // given
        String emptySource = "";
        String nullSource = null;

        // when
        assertThatThrownBy(() -> {
            StringCalculator.validateNone(emptySource);
        // then
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("빈 값은 사용할 수 없습니다.");

        // when
        assertThatThrownBy(() -> {
            StringCalculator.validateNone(nullSource);
            // then
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("null은 사용할 수 없습니다.");

    }

    @DisplayName(value = "사칙연산 기호가 아닌 경우 IllegalArgumentException")
    @Test
    void validateOperate() {
        // given
        String source = "1 + 2 ! 3";

        // when
        assertThatThrownBy(() -> {
            StringCalculator.validateOperate(source);
            // then
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사칙연산 기호가 아닙니다.");
    }
}