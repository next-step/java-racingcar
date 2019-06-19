package stringcalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExpressionTest {

    @DisplayName("사용자 입력 받기")
    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2"})
    void init(String source) {
        Expression expression = new Expression(source);

        assertThat(expression).isNotNull();
    }

    @DisplayName("입력값이 빈 공백 문자일 경우 IllegalArgumentException throw")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void nullOrEmptyStringThrowIllegalArgumentException(String source) {
        assertThatThrownBy(() -> new Expression(source))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 값은 null 이거나 빈 공백 문자일 수 없습니다.");
    }

    @DisplayName("입력값이 null일 경우 IllegalArgumentException throw")
    @ParameterizedTest
    @NullAndEmptySource
    void nullExpressionThrowIllegalArgumentException(String source) {
        assertThatThrownBy(() -> new Expression(source))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 값은 null 이거나 빈 공백 문자일 수 없습니다.");
    }

    @DisplayName("입력값 중 연산자가 사칙연산 기호가 아닌 경우")
    @ParameterizedTest
    @ValueSource(strings = {"1 A 3", "1 = !", "3 & 1"})
    void isNotPermittedOperatorTest(String source) {
        assertThatThrownBy(() -> new Expression(source))
                .hasMessageContaining("연산자는 사칙연산 기호만 사용할 수 있습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2", "1 = !", "3 & 1", "+ 2 3 2", "+ 9 + 2", "3 A 3 -"})
    public void test(String source) {
        //given
        String[] expressions = source.split(Constant.BLANK);

        int expressionsLength = expressions.length;

        long operatorCount = Stream.of(expressions)
                .filter(e -> e.matches(Constant.OPERATOR_PATTERN.toString()))
                .count();

        long numberCount = Stream.of(expressions)
                .filter(e -> e.matches(Constant.INTEGER_PATTERN.toString()))
                .count();

        long expectedOperatorsLength = expressionsLength - numberCount;

        if (expectedOperatorsLength > operatorCount) {
            System.out.println("연산자 개수 에러!");
        }

        System.out.println("expressionsLength               : " + expressionsLength);
        System.out.println("operatorCount                   : " + operatorCount);
        System.out.println("numberCount                     : " + numberCount);
        System.out.println("expectedOperatorsLength         : " + expectedOperatorsLength);
    }

    @DisplayName("입력된 표현식에서 사칙연산 기호의 개수와 숫자가 아닌 문자의 개수를 비교")
    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2 : 3 3 true", "1 = ! : 0 2 false"}, delimiter = ':')
    public void test2(String source, String expectedResult) {
        //given
        String[] expressions = source.split(Constant.BLANK);
        String[] brunchOfResult = expectedResult.split(Constant.BLANK);

        long operatorCount = Stream.of(expressions)
                .filter(e -> e.matches(Constant.OPERATOR_PATTERN.toString()))
                .count();

        long literalCount = Stream.of(expressions)
                .filter(e -> e.matches(Constant.LITERAL_PATTERN.toString()))
                .count();

        assertThat(operatorCount)
                .isEqualTo(Long.parseLong(brunchOfResult[0]));
        assertThat(literalCount)
                .isEqualTo(Long.parseLong(brunchOfResult[1]));
        assertThat(operatorCount == literalCount)
                .isEqualTo(Boolean.parseBoolean(brunchOfResult[2]));
    }

    @DisplayName("입력값은 반드시 숫자로 시작해야 한다")
    @ParameterizedTest
    @ValueSource(strings = {"A 1", "* 2", "$"})
    void expressionMustStartIntegerTest(String source) {
        assertThatThrownBy(() -> new Expression(source));
    }

}
