package calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;

import static calc.StringCalculatorTestCase.BLANK;
import static calc.StringCalculatorTestCase.DIVIDE_ZERO;
import static calc.StringCalculatorTestCase.HAS_DOUBLE_OPERATOR;
import static calc.StringCalculatorTestCase.HAS_LARGE_NUMBER;
import static calc.StringCalculatorTestCase.HAS_MANY_OPERATOR;
import static calc.StringCalculatorTestCase.HAS_NO_OPERAND;
import static calc.StringCalculatorTestCase.HAS_ONE_OPERATOR;
import static calc.StringCalculatorTestCase.ONE;
import static calc.StringCalculatorTestCase.PLUS_ONE;
import static calc.StringCalculatorTestCase.START_WITH_MINUS_HAS_LARGE_NUMBER;
import static calc.StringCalculatorTestCase.START_WITH_MINUS_HAS_MANY_OPERATIOR;
import static calc.StringCalculatorTestCase.START_WITH_MINUS_HAS_ONE_OPERATOR;
import static calc.StringCalculatorTestCase.START_WITH_MINUS_ONE;
import static calc.StringCalculatorTestCase.START_WITH_PLUS_HAS_LARGE_NUMBER;
import static calc.StringCalculatorTestCase.START_WITH_PLUS_HAS_MANY_OPERATIOR;
import static calc.StringCalculatorTestCase.START_WITH_PLUS_HAS_ONE_OPERATIOR;
import static calc.StringUtils.EMPTY;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringCalculatorMatchTest {

    private static final Pattern EXPRESSION_PATTERN =
            Pattern.compile("^([+-]?[\\d]+)([+-/*]\\d+)*$");

    @ParameterizedTest
    @CsvSource(value = {ONE, START_WITH_MINUS_ONE, PLUS_ONE, HAS_ONE_OPERATOR,
            START_WITH_MINUS_HAS_ONE_OPERATOR, START_WITH_PLUS_HAS_ONE_OPERATIOR, HAS_ONE_OPERATOR,
            HAS_MANY_OPERATOR, START_WITH_MINUS_HAS_MANY_OPERATIOR,
            START_WITH_PLUS_HAS_MANY_OPERATIOR, HAS_LARGE_NUMBER, START_WITH_MINUS_HAS_LARGE_NUMBER,
            START_WITH_PLUS_HAS_LARGE_NUMBER, DIVIDE_ZERO}, delimiter = '#')
    @DisplayName("유효한 식이 정규표현식과 맞는지 확인합니다")
    public void validExpressionTest(String input) {
        String expression = StringUtils.replaceWhitespaceCharacters(input, EMPTY);
        final Matcher matcher = EXPRESSION_PATTERN.matcher(expression);

        assertTrue(matcher.matches());
    }

    @ParameterizedTest
    @ValueSource(strings = {HAS_NO_OPERAND, HAS_DOUBLE_OPERATOR, BLANK})
    @DisplayName("잘못된 형식의 식이 정규표현식과 맞는지 확인합니다")
    public void invalidExpressionTest(String input) {
        String expression = StringUtils.replaceWhitespaceCharacters(input, EMPTY);
        final Matcher matcher = EXPRESSION_PATTERN.matcher(expression);

        assertFalse(matcher.matches());
    }
}
