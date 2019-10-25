package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalcTest {

    StringCalculator strCalc;
    InputValidator iv;

    @BeforeEach
    void setUp() {
        strCalc = new StringCalculator();
        iv = new InputValidator();
    }

    @ParameterizedTest
    @CsvSource(value = {"2,1"}, delimiter = ',')
    void calc(int a, int b) {
        assertThat(strCalc.add(a, b)).isEqualTo(3);
        assertThat(strCalc.subtract(a, b)).isEqualTo(1);
        assertThat(strCalc.multiply(a, b)).isEqualTo(2);
        assertThat(strCalc.division(a, b)).isEqualTo(2);
    }

    @ParameterizedTest
    @CsvSource(value = {"4 + 2 * 3 / 2:9"}, delimiter = ':')
    void calcTest(String inputStr, int result) {
        String[] data = iv.validate(inputStr).split(" ");
        int leftData = 0;
        int rightData = 0;
        String calculate;
        int maxI = data.length;
        for (int i = 0; i < maxI; i++) {
            if (i == 0) leftData = Integer.parseInt(data[i]);
            if (i % 2 == 1) {
                calculate = iv.calculateValidate(data[i]);
                rightData = Integer.parseInt(data[i + 1]);
                leftData = strCalc.calculate(leftData, rightData, calculate);
            }
        }
        assertThat(leftData).isEqualTo(result);
    }


}
