import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Java6Assertions.assertThat;

/*
    요구사항
    사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
    입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다.
    나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다.
    문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
    예를 들어 2 + 3 * 4 / 2와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.
 */
public class StringCalculatorTest {

    StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1000 + 20000 : 21000",
            "200 - 100 : 100",
            "20 / 5 : 4",
            "30 * 3 : 90",
            "2 + 6 * 2 / 8 : 2",
            "2 + 3 * 4 / 2 : 10",
            "20 / 3 * 4 - 2 : 22", }, delimiter = ':')
    public void 사칙연산_테스트(final String input, final int result) {
        assertThat(stringCalculator.calculateResult(input)).isEqualTo(result);
    }

    @DisplayName("입력값 split 테스트")
    @Test
    public void split_Test() {
        assertThat(stringCalculator.split("2 + 3 * 4 / 2")).containsExactly("2", "+", "3", "*", "4", "/", "2");
    }

    @DisplayName("입력 값이 공백일 경우 예외처리 테스트")
    @ParameterizedTest
    @ValueSource(strings = {" ", ""})
    public void 입력값은_공백이_아니어야한다(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> stringCalculator.isBlank(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사칙연산 기호가 아닌 경우 예외처리 테스트")
    @ParameterizedTest
    @ValueSource(strings = {
            "1 ! 2",
            "1 + 2 # 3",
            "2 * 3 ! 5",
            "6 ( 1 ~ 5",
            "9 ) 7 $ 8",
    })
    void 유효하지_않은_연산자_테스트 (String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> stringCalculator.calculateResult(input));
    }

    @DisplayName("0으로 나누었을 경우 예외처리 테스트")
    @ParameterizedTest
    @ValueSource(strings = "4 + 3 * 2 / 0")
    public void 모든값은_0으로_나눌수_없다(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(()-> stringCalculator.calculateResult(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
