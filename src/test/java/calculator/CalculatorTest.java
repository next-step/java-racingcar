package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CalculatorTest {

    @Test
    void add() {

        //given
        String inputString = "2 + 3";

        //when
        long result = Calculator.calculate(inputString);

        //then
        assertThat(result).isEqualTo(5);
    }

    @Test
    void minus() {

        //given
        String inputString = "5 - 2";

        //when
        long result = Calculator.calculate(inputString);

        //then
        assertThat(result).isEqualTo(3);
    }

    @Test
    void multiply() {

        //given
        String inputString = "3 * 4";

        //when
        long result = Calculator.calculate(inputString);

        //then
        assertThat(result).isEqualTo(12);
    }

    @Test
    void division() {

        //given
        String inputString = "20 / 2";

        //when
        long result = Calculator.calculate(inputString);

        //then
        assertThat(result).isEqualTo(10);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    @DisplayName("입력값이 비었거나, 공백일 경우 에러를 뱉는다")
    void isEmptyOrIsBlankThrowIllegalArgumentException(String input) {

        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator.calculate(input);
        });
    }

    @Test
    @DisplayName("입력값이 null일 경우 에러를 뱉는다")
    void ifNullThrowIllegalArgumentException() {

        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator.calculate(null);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "1 b 2", "a b c"})
    @DisplayName("사칙연산 기호가 아닐 경우 에러를 뱉는다.")
    void notValidCharacterThrowIllegalArgumentException(String input) {

        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator.calculate(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 2", "3 * 5 + 2 -", "+ 1"})
    @DisplayName("입력이 올바르지 않을 경우(순서오류, 숫자와 연산자의 갯수 오류) 에러를 뱉는다.")
    void isNotValidThrowIllegalArgumentException(String input) {

        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator.calculate(input);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10",
            "5        + 3 * 2 - 6 / 2:5",
            "100 - 10    / 3 + 5 * 2:70",
            "10 - 1 - 1 -       1 - 1 - 1:5"
    }, delimiter = ':')
    @DisplayName("사칙연산을 수행한다.(공백은 무시한다)")
    void calculate(String input, long result) {

        long number = Calculator.calculate(input);
        assertThat(number).isEqualTo(result);
    }

    @Test
    @DisplayName("0으로 나누면 에러를 떨군다.")
    void divisionZero() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            String input = "1 / 0";
            Calculator.calculate(input);
        }).withMessage("0으로 나눌 수 없습니다.");
    }
}
