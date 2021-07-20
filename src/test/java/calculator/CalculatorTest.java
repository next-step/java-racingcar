package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CalculatorTest {
    @DisplayName("정상 입력시 의도대로 계산된 값이 나오는지 테스트")
    @Test
    void calculateTest(){
        //given
        Calculator calculator = new Calculator(new Formula("5 + 5 * 5 / 25"));

        //when
        int result = calculator.calculate();

        //then
        assertThat(2).isEqualTo(result);
    }

    @DisplayName("0 으로 나눌 시 IllegalArgumentException 발생 하는지 테스트")
    @Test
    void divideZeroTest(){
        //given
        Calculator calculator = new Calculator(new Formula("2 + 2 * 10 / 0"));

        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            int result = calculator.calculate();
            assertThat(2).isEqualTo(result);
        });
    }


    @DisplayName("입력 값이 null 이거나 빈 공백 문자일 경우 IllegalArgumentException 발생 하는지 테스트")
    @Test
    void inputNullOrEmptyTest(){
        //given
        Calculator calculator = new Calculator(new Formula("2 +   * 2 / 2"));

        //when, then
        assertThatIllegalArgumentException().isThrownBy(calculator::calculate);
    }

    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException throw")
    @Test
    void checkPermittedOperator(){
        //given
        Calculator calculator = new Calculator(new Formula("2 $ 6 * 5 / 4"));

        //when, then
        assertThatIllegalArgumentException().isThrownBy(calculator::calculate);
    }

    @DisplayName("숫자 숫자 연속될경우 IllegalArgumentException throw")
    @Test
    void checkNotPermittedNumberNumberSequence(){
        //given
        Calculator calculator = new Calculator(new Formula("2 6 * 5 / 4"));

        //when, then
        assertThatIllegalArgumentException().isThrownBy(calculator::calculate);
    }

    @DisplayName("오퍼레이터 오퍼레이터 연속될경우 IllegalArgumentException throw")
    @Test
    void checkNotPermittedOperatorOperatorSequence(){
        //given
        Calculator calculator = new Calculator(new Formula("2 + + 6 * 5 / 4"));

        //when, then
        assertThatIllegalArgumentException().isThrownBy(calculator::calculate);
    }
}