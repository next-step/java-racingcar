package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalcTest {

    StringCalculator strCalc;

    @BeforeEach
    void setUp() {
        strCalc = new StringCalculator();
    }

    @ParameterizedTest
    @CsvSource(value = {"2,1"}, delimiter = ',')
    void calc(int a, int b) {
        assertThat(strCalc.add(a, b)).isEqualTo(3);
        assertThat(strCalc.subtract(a, b)).isEqualTo(1);
        assertThat(strCalc.multiply(a, b)).isEqualTo(2);
        assertThat(strCalc.division(a, b)).isEqualTo(2);
    }


}
