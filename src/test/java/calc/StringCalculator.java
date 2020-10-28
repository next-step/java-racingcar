package calc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculator {

    public static final String OPERATION_REG = "[+\\-*/]";

    public static final String NUMBER_REG = "\\d";

    /*
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
        final String expression = "1";

        // when
        final String[] numbers = splitNumbers(expression);

        // then
        assertThat(numbers).containsExactly("1");
    }

    @Test
    @DisplayName("음수만 있는 문자열 스플릿 테스트")
    public void 음수만_있는_문자열_스플릿_테스트() {

        // given
        final String expression = "-1";

        // when
        final String[] numbers = splitNumbers(expression);

        // then
        // 사칙연산 정규표현식과 일치하는 첫 번째 문자열은 ""로 바뀐다
        assertThat(numbers).containsExactly("", "1");
    }

    @Test
    @DisplayName("부호가 1개 있는 문자열 스플릿 테스트")
    public void 부호가_1개_있는_문자열_스플릿_테스트() {

    }

    private static String[] splitNumbers(final String expression) {
        return expression.split(OPERATION_REG);
    }

    private static String[] splitOperations(final String expression) {
        return expression.split(NUMBER_REG);
    }
}
