package calc;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringCalculatorSplitTest {

    public static final String OPERATION_REG = "[+\\-*/]";

    public static final String NUMBER_REG = "\\d";

    /*
    0. 주어진 식의 공백을 모두 제거한다.
    1. 숫자 배열을 생성하도록 split 한다. numbers = String#split("[+\\-/*]")
    2. 부호 배열을 생성하도록 split 한다. operations = String#split("\\d")
    3. 주어진 식의 맨 앞이 - 로 시작하는지 확인한다. String#startswith("-")
        3-1. 만약 - 로 시작하면
            3-1-1. numbers.length == operations.length 을 확인(throw IllegalArgumentException)
            3-1-2. 첫 번째 숫자에 - 를 곱하고, operationIndex 를 1로 설정
        3-2. 그렇지 않으면 numbers.length - 1 == operations.length 을 확인(throw IllegalArgumentException)
    4. 반복문으로 numbers[numberIndex] 와 [numberIndex + 1] 을 operations[operationIndex] 를 이용하여 계산
        4-1. 중간에 사칙연산이 아닌 부호를 만난다면 throw IllegalArgumentException
     */

    @Test
    @DisplayName("양수만 있는 문자열 스플릿 테스트")
    public void 양수만_있는_문자열_스플릿_테스트() {

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
    public void 음수만_있는_문자열_스플릿_테스트() {

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
    public void 부호가_1개_있는_문자열_스플릿_테스트() {

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
    public void 부호가_여러_개_있는_문자열_스플릿_테스트() {

        // given
        final String expression = removeWhiteSpace("1 + 2 - 3 * 4 / 5");

        // when
        final String[] numbers = splitNumbers(expression);
        final String[] operations = splitOperations(expression);


        // then
        assertThat(numbers).containsExactly("1", "2", "3", "4", "5");
        assertThat(operations).containsExactly("", "+", "-", "*", "/");
    }

    private static String[] splitNumbers(final String expression) {
        return expression.split(OPERATION_REG);
    }

    private static String[] splitOperations(final String expression) {
        return expression.split(NUMBER_REG);
    }

    private static String removeWhiteSpace(String expression) {
        return StringUtils.replaceWhitespaceCharacters(expression, "");
    }
}
