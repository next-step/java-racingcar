package stydy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    final String REG_EXP = "[,:]";

    @ParameterizedTest
    @NullAndEmptySource
    void calculatorTest1(String input) {

        int result = basicCalculator(input, REG_EXP);
        assertThat(result).isEqualTo(0);

    }

    @ParameterizedTest
    @CsvSource(value = {"1=1", "1,2=3", "1,2:3=6"},delimiter = '=')
    void calculator(String input, String output) {

        int totalResult = Integer.parseInt(output);
        int result = basicCalculator(input, REG_EXP);
        assertThat(result).isEqualTo(totalResult);

    }

    @Test
    void customCalculator() {

        String input = "//;\n1;2;3";
        Matcher matcher = Pattern.compile("^//(.)\n(.*)").matcher(input);

        if(matcher.find()) {
            String group1 = matcher.group(1);
            String group2 = matcher.group(2);

            basicCalculator(group2, group1);
        }
    }

    @Test
    void negativeCaculatir() {
        String input = "-1,2,3";
        basicCalculator(input, REG_EXP);
    }

    int basicCalculator(String input, String regExp) {

        int sum = 0;

        if(input == null || input.isEmpty()) {
            return sum;
        }

        String[] arr = input.split(regExp);

        for(int i = 0; i < arr.length; i++) {
            int result = Integer.parseInt(arr[i]);

            if(result < 0) {
                Assertions.assertThrows(InputMismatchException.class, () -> {
                });
            }
            sum += result;
        }
        return sum;
    }

}