package study.step02;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing_car.Application;
import racing_car.Calculator;
import racing_car.Validation;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    private Calculator calculator;
    private Validation validation;

    @BeforeEach
    void init() {
        calculator = new Calculator();
        validation = new Validation();
    }

    @Test
    @DisplayName("사칙연산 결과 테스트")
    public void resultTest() {
        //given
        String str = "2 + 10 * 3 / 6";
        //when
        int answer = calculator.validationCheck(str.split(" "));
        //then
        Assertions.assertThat(answer).isEqualTo(6);
    }

    @Test
    @DisplayName("입력 값이 null이거나 빈 문자열 일때 예외 처리 테스트")
    public void inputNull() {
        //given
        Assertions.assertThatThrownBy(()-> validation.nullCheck("")).isInstanceOf(IllegalArgumentException.class);
        //when

        //then

    }

}