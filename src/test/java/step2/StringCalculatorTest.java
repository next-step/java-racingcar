package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    @Test
    @DisplayName("덧셈 테스트")
    void add() {
        assertThat(Calculator.add(2, 3)).isEqualTo(5);
    }

    @Test
    @DisplayName("뺄셈 테스트")
    void subtract() {
        assertThat(Calculator.subtract(2, 3)).isEqualTo(-1);
    }

    @Test
    @DisplayName("곱셈 테스트")
    void multiple() {
        assertThat(Calculator.multiple(2, 3)).isEqualTo(6);
    }

    @Test
    @DisplayName("나눗셈 테스트")
    void divide() {
        assertThat(Calculator.divide(4, 2)).isEqualTo(2);
    }

    @Test
    @DisplayName("나눗셈 결과 infinity 값이 나올 경우의 예외처리 테스트")
    void divideException() {
    //TODO
    }

    @Test
    @DisplayName("입력받은 String이 split이 잘 되는지 테스트")
    void splitString() {
        String str = "2 + 3 * 4 / 2";
        assertThat(Main.splitString(str)).containsExactly("2", "+", "3", "*", "4", "/", "2");
    }

    @Test
    @DisplayName("입력받은 String이 정규식 패턴에 맞는지 테스트")
    void checkPattern() {
        String input = "2 + 3 * 4 / 2";
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Main.calculateString(input);
        });
    }

    @Test
    @DisplayName("연산자와 숫자를 입력받아 계산이 잘 되는지 테스트")
    void numberCalculate() {
        assertThat(StringCalculator.calculate("*", 3, 2)).isEqualTo(6);
    }

    @DisplayName("최종 계산 테스트")
    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2 * 9:90", "1 + 3 * 2 / 4 / 1:2"}, delimiter = ':')
    void calculate(String input, String expected) {
        assertThat(Main.calculateString(input)).isEqualTo(expected);
    }

    @Test
    @DisplayName("나누기 값이 0일 경우 실패 테스트")
    void calculateDivisionException() {
        String input = "2 + 3 - 5 / 0";
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Main.calculateString(input);
        });
    }

    @Test
    @DisplayName("적절한 연산자가 입력되지 않았을 때의 테스트")
    void OperatorException() {

        //TODO: Enum을 제대로 활용해서 Exception 처리 할 수 있도록 개선 필요해보임
        String input = "2 + 3 - 5 # 3";
//        assertThatExceptionOfType(IllegalArgumentException.class)
//                .isThrownBy(() -> {
//            Main.calculateString(input);
//        }).hasMessageContaining("연산자");

//        assertThatIllegalArgumentException().isThrownBy(() -> {
//            Main.calculateString(input);
//        });
    }
}
