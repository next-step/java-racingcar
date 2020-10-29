package StringInputCalcualtor;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleCalculatorTest {
    SimpleCalculator simpleCalculator = new SimpleCalculator();

    @Test
    void testAdd() {
        BigDecimal result = simpleCalculator.add(BigDecimal.valueOf(1), BigDecimal.valueOf(2));
        assertThat(result).isEqualTo(BigDecimal.valueOf(3));
    }

    @Test
    void testSubtract() {
        BigDecimal result = simpleCalculator.subtract(BigDecimal.valueOf(1), BigDecimal.valueOf(2));
        assertThat(result).isEqualTo(BigDecimal.valueOf(-1));
    }

    @Test
    void testMultiply() {
        BigDecimal result = simpleCalculator.multiply(BigDecimal.valueOf(1), BigDecimal.valueOf(2));
        assertThat(result).isEqualTo(BigDecimal.valueOf(2));
    }

    @Test
    void testDivide() {
        BigDecimal result = simpleCalculator.divide(BigDecimal.valueOf(1), BigDecimal.valueOf(2));
        assertThat(result).isEqualTo(BigDecimal.valueOf(0));

        BigDecimal result2 = simpleCalculator.divide(BigDecimal.valueOf(3), BigDecimal.valueOf(1));
        assertThat(result2).isEqualTo(BigDecimal.valueOf(3));

        BigDecimal result3 = simpleCalculator.divide(BigDecimal.valueOf(5), BigDecimal.valueOf(2));
        assertThat(result3).isEqualTo(BigDecimal.valueOf(2));
    }

    @ParameterizedTest
    @CsvSource(value = {"+,1,2,3", "*,1,2,2", "/,1,2,0", "-,1,2,-1", "-,3,2,1", "/,3,2,1", "/,5,2,2", "/,3,1,3"}, delimiter = ',')
    void operateTest(String operator, BigDecimal a, BigDecimal b, BigDecimal expected) {
        BigDecimal result = simpleCalculator.operate(operator, a, b);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void operateReducerTest() {
        BigDecimal result = simpleCalculator.operate(Arrays.asList("+", "*", "-", "/"),
                Arrays.asList(BigDecimal.valueOf(2),
                        BigDecimal.valueOf(3),
                        BigDecimal.valueOf(2),
                        BigDecimal.valueOf(1),
                        BigDecimal.valueOf(2)));
        assertThat(result).isEqualTo(BigDecimal.valueOf(2).add(BigDecimal.valueOf(3)).multiply(BigDecimal.valueOf(2)).subtract(BigDecimal.valueOf(1)).divide(BigDecimal.valueOf(2), RoundingMode.FLOOR));
    }
}
