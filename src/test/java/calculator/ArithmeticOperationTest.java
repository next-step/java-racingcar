package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class ArithmeticOperationTest {

    @DisplayName("사칙연산 테스트")
    @Test
    public void calculateInput() throws Exception {
        //given
        double num1 = 1;
        double num2 = 2;
        //then
        assertAll(
                () -> assertThat((ArithmeticOperation.calculateInput(num1, num2, "+"))).isEqualTo(3),
                () -> assertThat(ArithmeticOperation.calculateInput(num1, num2, "-")).isEqualTo(-1),
                () -> assertThat(ArithmeticOperation.calculateInput(num2, num2, "*")).isEqualTo(4),
                () -> assertThat(ArithmeticOperation.calculateInput(num2, num2, "/")).isEqualTo(1),
                () -> assertThat(ArithmeticOperation.calculateInput(num2, num2, "+")).isNotEqualTo(1)
        );
    }
}
