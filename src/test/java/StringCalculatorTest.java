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
    private String arg;

    StringCalculator (String arg) {
        this.arg = arg;
        validation();
    }

    void validation () {
        if (StringUtils.isEmpty(arg)) throw new IllegalArgumentException();

        for (String x: StringUtils.blankSplit(arg)) {
            validationArgument(x);
        }
    }

    void validationArgument (String x) {
        if ( !StringUtils.isInteger(x) && !StringUtils.isCalculateText(x))
            throw new IllegalArgumentException();
    }

    private enum Calculator {
        PLUS("+"){
            @Override
            public int calculate(int a, int b) {
                return a + b;
            }
        },
        MINUS("-") {
            @Override
            public int calculate(int a, int b) {
                return a - b;
            }
        },
        DIVISION("/") {
            @Override
            public int calculate(int a, int b) {
                if (a % b > 0) throw new NumberFormatException("Only integers can be entered");
                return a / b;
            }
        },
        MULTILPICATION("*") {
            @Override
            public int calculate(int a, int b) {
                return a * b;
            }
        };

        private final String calcType;

        Calculator(String calcType) { this.calcType = calcType; }

        public abstract int calculate(int a, int b);

        public static Calculator of(String calcType) {
            switch (calcType) {
                case "+":
                    return Calculator.PLUS;
                case "-":
                    return Calculator.MINUS;
                case "/":
                    return Calculator.DIVISION;
                case "*":
                    return Calculator.MULTILPICATION;
                default:
                    throw new IllegalArgumentException();
            }
        }
    }

    int calculate () {
        List integers = StringUtils.sortingToList(StringUtils.SortString.INTEGER, this.arg);
        List calTypes = StringUtils.sortingToList(StringUtils.SortString.CALC_TEXT, this.arg);

        Iterator integerIter = integers.iterator();
        Iterator calcTypeIter = calTypes.iterator();
        int a = (int) integerIter.next();
        while (integerIter.hasNext()) {
            int b = (int) integerIter.next();
            String calcType = calcTypeIter.next().toString();
            a = Calculator.of(calcType)
                    .calculate(a, b);
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

    public enum SortString {
        INTEGER(1) {
            @Override
            public void addList(List list, String arg) {
                if (StringUtils.isInteger(arg)) {
                    list.add(Integer.parseInt(arg));
                }
            }
        },
        CALC_TEXT(2) {
            @Override
            public void addList(List list, String arg) {
                if (StringUtils.isCalculateText(arg)) {
                    list.add(arg);
                }
            }
        };

        private int sortType;

        SortString(int sortType) { this.sortType = sortType; }

        public abstract void addList(List list, String arg);
    }

    public static List sortingToList (SortString sortString, String x) {
        List list = new ArrayList<>();
        for (String str: blankSplit(x)) {
            sortString.addList(list, str);
        }
        return list;
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

