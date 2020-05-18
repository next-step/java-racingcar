package study.step2_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void calculatorSetup(){
        stringCalculator = new StringCalculator();
    }

    @ParameterizedTest
    @DisplayName("덧셈 테스트")
    @CsvSource(value ={"1 + 2 = 3", "2 + 2 = 4", "3 + 5 = 8"}, delimiter = '=')
    void addTest(String input, double result){
        assertThat(stringCalculator.calculate(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("뺄셈 테스트")
    @CsvSource(value ={"3 - 2 = 1", "4 - 2 = 2", "5 - 5 = 0"}, delimiter = '=')
    void subtractTest(String input, double result){
        assertThat(stringCalculator.calculate(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("곱셈 테스트")
    @CsvSource(value ={"3 * 2 = 6", "4 * 2 = 8", "5 * 5 = 25"}, delimiter = '=')
    void multiplyTest(String input, double result){
        assertThat(stringCalculator.calculate(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("나눗셈 테스트")
    @CsvSource(value ={"6 / 2 = 3", "4 / 2 = 2", "5 / 5 = 1"}, delimiter = '=')
    void divisionTest(String input, double result){
        assertThat(stringCalculator.calculate(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("사칙연산 전체 혼합 테스트")
    @CsvSource(value ={"2 + 3 * 4 / 2 = 10", "5 - 2 * 4 / 2 + 6 = 12", "3 + 3 / 2 * 5 - 1 = 14"}, delimiter = '=')
    void operationsTest(String input, double result){
        assertThat(stringCalculator.calculate(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw 하는 것 테스트")
    @ValueSource(strings = {"", " "})
    void returnExceptionCheckByBlankCheck(String input) {
        assertThatIllegalArgumentException().isThrownBy(()->{
            stringCalculator.calculate(input);
        });
    }

    @ParameterizedTest
    @DisplayName("사칙연산 기호 체크하는 메소드 테스트")
    @ValueSource(strings = {"3 + 5 & 4", "=","% 4 $ 2","3 * d"})
    void operationsSymbolCheck(String input) {
        assertThatIllegalArgumentException().isThrownBy(()->{
            stringCalculator.calculate(input);
        });
    }

    @ParameterizedTest
    @DisplayName("0으로 나눌 경우 IllegalArgumentException throw 하는 것 테스트")
    @ValueSource(strings = {"3 + 5 / 0"})
    void zeroMakeExceptionCheck(String input) {
        assertThatIllegalArgumentException().isThrownBy(()->{
            stringCalculator.calculate(input);
        });
    }

<<<<<<< HEAD
    @ParameterizedTest
    @DisplayName("사칙연산 기호 제대로 찾는지 메소드 체크 테스트")
    @CsvSource(value ={"+=ADD", "-=SUBTRACT", "*=MULTIPLY", "/=DIVISION"}, delimiter = '=')
    void findOperatorMethodCheck(String input, String expected) {
        assertThat(Operator.findOperator(input)).isEqualByComparingTo(Operator.valueOf(expected));
    }

    @ParameterizedTest
    @DisplayName("사칙연산 기호 없는 것 요청시 IllegalArgumentException 발생여부 체크 테스트")
    @ValueSource(strings = {"&", "%", "$$", "#", " "})
    void cantfindOperatorMethodCheck(String input) {
        assertThatIllegalArgumentException().isThrownBy(()->{
            Operator.findOperator(input);
        });
    }

    @ParameterizedTest
    @DisplayName("isOperator 메소드 테스트")
    @ValueSource(strings = {"+", "-", "*", "/"})
    void isOperatorMethodTest(String input) {
        assertThat(Operator.isOperator(input)).isTrue();
    }

=======
>>>>>>> d1896fdcab2eb83ee20138f031ab12d323e07844
}