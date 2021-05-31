package calculate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculateTest {
    Calculate calcul = new Calculate();

    @Test
    void resultMethod() {
        assertThat(calcul.resultMethod("2+3", "+")).isEqualTo(5);
    }

    @ParameterizedTest
    @CsvSource(value = {"2+3:5", "2+8:10"}, delimiter = ':')
    void add(String cal, int resultCheckNumber) {
        assertThat(calcul.resultMethod(cal, "+")).isEqualTo(resultCheckNumber);
    }

    @ParameterizedTest
    @CsvSource(value = {"8-2:6 ", "150-3:147"}, delimiter = ':')
    void sub(String cal, int resultCheckNumber) {
        assertThat(calcul.resultMethod(cal, "-")).isEqualTo(resultCheckNumber);

    }

    @ParameterizedTest
    @CsvSource(value = {"8/2:4 ", "150/3:50"}, delimiter = ':')
    void dvide(String cal, int resultCheckNumber) {
        assertThat(calcul.resultMethod(cal, "/")).isEqualTo(resultCheckNumber);
    }

    @ParameterizedTest
    @CsvSource(value = {"8*2:16 ", "150*3:450"}, delimiter = ':')
    void multyple(String cal, int resultCheckNumber) {
        assertThat(calcul.resultMethod(cal, "*")).isEqualTo(resultCheckNumber);
    }

    @Test
    void cal() {
        String str = "2 + 3 * 4 / 2";
        double result = Double.parseDouble(calcul.requestCal(str));
        assertThat(result).isEqualTo(10);
    }
}
