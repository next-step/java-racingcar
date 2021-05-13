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
    int resultMethod(String cal, char method) {
        int split_num1, split_num2, result;
        String[] split = cal.split("[+]");
        split_num1 = Integer.parseInt(split[0]);
        split_num2 = Integer.parseInt(split[1]);
        result = split_num1 + method + split_num2;
        if (method == '+') {
            result = split_num1 + split_num2;
        } else if (method == '-') {
            result = split_num1 - split_num2;
        } else if (method == '*') {
            result = split_num1 * split_num2;
        } else if (method == '/') {
            result = split_num1 / split_num2;
        }
        return result;
    }

    @ParameterizedTest
    @CsvSource(value = {"2+3:5", "2+8:10"}, delimiter = ':')
    void add(String cal, int resultCheckNumber) {
        assertThat(resultMethod(cal, '+')).isEqualTo(resultCheckNumber);
    }

    @ParameterizedTest
    @CsvSource(value = {"8-2:6 ", "150-3:147"}, delimiter = ':')
    void sub(String cal, int resultCheckNumber) {
        assertThat(resultMethod(cal, '-')).isEqualTo(resultCheckNumber);

    }

    @ParameterizedTest
    @CsvSource(value = {"8/2:4 ", "150/3:50"}, delimiter = ':')
    void dvide(String cal, int resultCheckNumber) {
        assertThat(resultMethod(cal, '/')).isEqualTo(resultCheckNumber);
    }

    @ParameterizedTest
    @CsvSource(value = {"8*2:16 ", "150*3:450"}, delimiter = ':')
    void multyple(String cal, int resultCheckNumber) {
        assertThat(resultMethod(cal, '*')).isEqualTo(resultCheckNumber);
    }

    @Test
    void cal() {
        String str = "2 + 3 * 4 / 2";
        double result = Double.parseDouble(calcul.requestCal(str));
        assertThat(result).isEqualTo((double) 10);
    }
}
