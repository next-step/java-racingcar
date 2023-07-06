package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorRunnerTest {

    @DisplayName("빈 문자열이 주어졌을 때 0을 결과로 반환한다")
    @Test
    void 빈_문자열_덧셈() {
        String input = "";

        int result = StringCalculatorRunner.run(input);

        assertThat(result).isEqualTo(0);
    }

    @DisplayName("null이 주어졌을 때 해당 값을 결과로 반환한다")
    @Test
    void 널_덧셈() {
        String input = null;

        int result = StringCalculatorRunner.run(input);

        assertThat(result).isEqualTo(0);
    }

    @DisplayName("하나의 숫자로 값이 주어졌을 때 해당 값을 결과로 반환한다")
    @Test
    void 한_숫자_덧셈() {
        String input = "7";

        int result = StringCalculatorRunner.run(input);

        assertThat(result).isEqualTo(7);
    }

    @DisplayName("일반 구분자로 값이 주어졌을 때 올바른 계산 결과를 반환한다")
    @Test
    void 일반_구분자_덧셈() {
        String input = "1,4:10";

        int result = StringCalculatorRunner.run(input);

        assertThat(result).isEqualTo(15);
    }

    @DisplayName("커스텀 구분자로 값들이 주어졌을 때 올바른 계산 결과를 반환한다")
    @Test
    void 커스텀_구분자_덧셈() {
        String input = "//<\n1<4<9";

        int result = StringCalculatorRunner.run(input);

        assertThat(result).isEqualTo(14);
    }
}
