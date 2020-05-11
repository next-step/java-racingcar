package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp(){
        calculator = input -> Double.valueOf(input);
    }

    @Test
    @DisplayName("계산 시 입력 값은 double 형으로 변환하여 반환한다.")
    void emptyCalculateTest(){
        String input = "2";
        Double expected = 2d;

        double result = calculator.calculate(input);

        assertThat(result).isEqualTo(expected);
    }
}
