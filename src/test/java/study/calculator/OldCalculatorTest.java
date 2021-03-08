package study.calculator;

import calculator.OldCalculator;
import calculator.CalculatorErrorMessage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


@DisplayName("계산기 종합 테스트")
public class OldCalculatorTest {

    private static OldCalculator calculator;

    @BeforeAll
    public static void setUp() {
        calculator = new OldCalculator();
    }

    // 테스트 순서를 보면. 구현부터하고 테스트한걸 알 수 있다.
    // 구현 -> 테스트로 TDD 가 아닌 구현을 중심으로 진행했음
    // TDD 방식은 테스트 -> 구현으로
    // 계산기가 되기 위해 가장 작은 단위로 시작하고 구현으로 옮기는 것.
    //
    @ParameterizedTest
    @CsvSource(value = {"2 + 1 + 2 * 5 / 5 - 111:-106", "10 + 1 + 2 / 5:2"}, delimiter = ':')
    @DisplayName("계산기 확인")
    public void calculatorWorkTest(String input, int checkNumber) throws Exception {
        //given

        //when
        int result = calculator.work(input);

        //then
        assertThat(result).isEqualTo(checkNumber);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    @DisplayName("공백 문자열 예외 처리 테스트")
    public void blankValueExceptionTest(String input) throws Exception {
        //given

        //when
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.work(input);
        });

        //then
    }

    @Test
    @DisplayName("사칙연산 기호가 아닐 경우 예외 처리 테스트")
    public void notArithmeticSymbolExceptionTest() throws Exception {
        //given
        String input = "2 ! 1 x 2 ㅇ 5 / 5";

        //when
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.work(input);
        });

        //then

    }

    @Test
    @DisplayName("숫자가 아닐 경우 예외 처리 테스트")
    public void notaNumberExceptionTest() throws Exception {
        //given
        String input = "a + b + c";

        //when
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.work(input);
        });

        //then
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 -", "9"})
    @DisplayName("2글자이하 예외 처리 테스트")
    public void sizeDownExceptionTeest(String input) throws Exception {
        //given

        //when
        Exception ex = assertThrows(Exception.class, () -> {
            calculator.work(input);
        });

        //then
        assertThat(ex.getMessage()).isEqualTo(CalculatorErrorMessage.SIZE_THREE_DOWN_ERROR);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 - 2 -", "9 * 10 +"})
    @DisplayName("짝수 예외 처리 테스트")
    public void sizeEvenExceptionTeest(String input) throws Exception {
        //given

        //when
        Exception ex = assertThrows(Exception.class, () -> {
            calculator.work(input);
        });

        //then
        assertThat(ex.getMessage()).isEqualTo(CalculatorErrorMessage.SIZE_EVEN_ERROR);
    }

}
