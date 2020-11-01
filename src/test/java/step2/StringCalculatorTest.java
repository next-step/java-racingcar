package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringCalculatorTest {

    StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    @DisplayName("덧셈 테스트")
    void checkPlusTest() {
        assertThat(calculator.plus(4, 3)).isEqualTo(7);
    }

    @Test
    @DisplayName("뺄셈 테스트")
    void checkMinusTest() {
        assertThat(calculator.minus(4, 3)).isEqualTo(1);
    }

    @Test
    @DisplayName("곱셈 테스트")
    void checkMultipleTest() {
        assertThat(calculator.multiple(4, 3)).isEqualTo(12);
    }

    @Test
    @DisplayName("나눗셈 테스트 - 정상")
    void checkDivideTest() {
        assertThat(calculator.divide(4, 3)).isEqualTo(1);
    }

    @Test
    @DisplayName("나눗셈 테스트 - 0으로 나누면 에러")
    void checkDivideZeroErrorTest() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.divide(4, 0));
    }

//    @ParameterizedTest
//    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
//    @DisplayName("요구사항 3 - 1, 2, 3 값은 contains 메소드 실행결과 true, 4, 5 값을 넣으면 false 가 반환되는 테스트를 " +

}