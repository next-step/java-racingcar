import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class StringCalculator {
    String arg;

    StringCalculator (String arg) {
        this.arg = arg;
        validationArgument();
    }

    int plus (int a, int b) {
        return a + b;
    }

    int minus (int a, int b) {
        return a - b;
    }

    int division (int a, int b) {
        return a / b;
    }

    void validationDivision (int a, int b) {
        if (a % b > 0) throw new NumberFormatException("Only integers can be entered");
    }

    int multiplication (int a, int b) {
        return a * b;
    }

    void validationArgument () {
        if (StringUtils.isEmpty(arg)) throw new IllegalArgumentException();
    }

    void validationCalculateString (String x) {
        if (!StringUtils.isCalculateText(x)) throw new IllegalArgumentException();
    }

    int executeCalcType (String calcType, int a, int b) {
        validationCalculateString(calcType);

        int result = 0;
        if ("+".equals(calcType)) {
            result = plus(a, b);

        } else if ("-".equals(calcType)) {
            result = minus(a, b);

        } else if ("/".equals(calcType)) {
            validationDivision(a, b);
            result = division(a, b);

        } else if ("*".equals(calcType)) {
            result = multiplication(a, b);
        }
        return result;
    }

    int calculate () {
        List<Integer> integers = StringUtils.toIntegers(this.arg);
        List<String> calTypes = StringUtils.toCalcTypes(this.arg);

        Iterator<Integer> integerIter = integers.iterator();
        Iterator<String> calcTypeIter = calTypes.iterator();
        int a = integerIter.next();
        while (integerIter.hasNext()) {
            int b = integerIter.next();
            String calcType = calcTypeIter.next();
            a = executeCalcType(calcType, a, b);
        }
        return a;
    }
}

class StringUtils {
    public static String[] blankSplit (String string){
        return string.split(" ");
    }

    public static boolean isEmpty (String string) {
        return (string == null || string.equals("") || string.equals(" "));
    }

    public static boolean isCalculateText (String x) {
        return ("+".equals(x) || "-".equals(x) || "/".equals(x) || "*".equals(x));
    }

    public static boolean isInteger (String x) {
        try {
            Integer.parseInt(x);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static List<Integer> toIntegers (String x) {
        List<Integer> integers = new ArrayList<>();
        for (String str: blankSplit(x)) {
            if (isInteger(str)) {
                integers.add(Integer.parseInt(str));
            }
        }
        return integers;
    }

    public static List<String> toCalcTypes (String x) {
        List<String> calcTypes = new ArrayList<>();
        for (String str: StringUtils.blankSplit(x)) {
            if (isCalculateText(str)) {
                calcTypes.add(str);
            }
        }
        return calcTypes;
    }
}

class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1 + 2:3"}, delimiter = ':')
    void testPlus (String input, int expected) {
        assertThat(new StringCalculator(input)
                .calculate())
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"5 - 1:4"}, delimiter = ':')
    void testMinus (String input, int expected) {
        assertThat(new StringCalculator(input)
                .calculate())
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"10 / 2:5"}, delimiter = ':')
    void testDivision (String input, int expected) {
        assertThat(new StringCalculator(input)
                .calculate())
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"5 * 2:10"}, delimiter = ':')
    void testMultiplication (String input, int expected) {
        assertThat(new StringCalculator(input)
                .calculate())
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void testArgumentValidation (String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new StringCalculator(input);
                });
    }

    @ParameterizedTest
    @ValueSource(strings = {"5 n 5", "2 < 0"})
    void testCalcTypeValidation (String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new StringCalculator(input).calculate();
                });
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "50 / 10 + 5 - 8:2"}, delimiter = ':')
    void testMulttipleCalculate(String input, int expected) {
        assertThat(new StringCalculator(input)
                .calculate())
                .isEqualTo(expected);
    }
}

