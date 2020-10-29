package calc;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import static calc.Separator.splitNumbers;
import static calc.Separator.splitOperations;
import static calc.StringUtils.EMPTY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringCalculatorSplitTest {

    @Test
    @DisplayName("양수만 있는 문자열 스플릿 테스트")
    public void oneSplitTest() {

        // given
        final String expression = removeWhiteSpace("1");

        // when
        final String[] numbers = splitNumbers(expression);
        final String[] operations = splitOperations(expression);

        // then
        assertThat(numbers).containsExactly("1");
        assertTrue(Arrays.isNullOrEmpty(operations));
    }

    @Test
    @DisplayName("음수만 있는 문자열 스플릿 테스트")
    public void minusOneSplitTest() {

        // given
        final String expression = removeWhiteSpace("- 1");

        // when
        final String[] numbers = splitNumbers(expression);
        final String[] operations = splitOperations(expression);

        // then
        // 사칙연산 정규표현식과 일치하는 첫 번째 문자열은 ""로 바뀐다
        assertThat(numbers).containsExactly("", "1");
        assertThat(operations).containsExactly("-");
    }

    @Test
    @DisplayName("부호가 1개 있는 문자열 스플릿 테스트")
    public void hasOneOperatorSplitTest() {

        // given
        final String expression = removeWhiteSpace("1 + 2");

        // when
        final String[] numbers = splitNumbers(expression);
        final String[] operations = splitOperations(expression);

        // then
        assertThat(numbers).containsExactly("1", "2");

        // 부호는 숫자를 기준으로 찾는다. 주어진 숫자는 2개이므로, 배열의 크기는 2이여야 한다.
        assertThat(operations).containsExactly("", "+");
    }

    @Test
    @DisplayName("부호가 여러 개 있는 문자열 스플릿 테스트")
    public void hasManyOperatorSplitTest() {

        // given
        final String expression = removeWhiteSpace("1 + 2 - 3 * 4 / 5");

        // when
        final String[] numbers = splitNumbers(expression);
        final String[] operations = splitOperations(expression);


        // then
        assertThat(numbers).containsExactly("1", "2", "3", "4", "5");
        assertThat(operations).containsExactly("", "+", "-", "*", "/");
    }

    @Test
    @DisplayName("처음 숫자가 음수이고 부호가 여러 개 있는 문자열 스플릿 테스트")
    public void startWithMinusHasManyOperatorSplitTest() {

        // given
        final String expression = removeWhiteSpace("- 1 + 2 - 3 * 4 / 5");

        // when
        final String[] numbers = splitNumbers(expression);
        final String[] operations = splitOperations(expression);


        // then
        assertThat(numbers).containsExactly("", "1", "2", "3", "4", "5");
        assertThat(operations).containsExactly("-", "+", "-", "*", "/");
    }

    private static String removeWhiteSpace(String expression) {
        return StringUtils.replaceWhitespaceCharacters(expression, EMPTY);
    }
}
