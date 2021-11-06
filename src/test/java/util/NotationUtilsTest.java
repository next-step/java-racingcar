package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("표기법 관련 기능 테스트")
class NotationUtilsTest {

    public static final String DELIMITER = " ";

    @DisplayName("중위 수식이 후위 수식으로 변환되는지 확인")
    @ParameterizedTest
    @CsvSource({"2 + 3 * 4 / 2,23+4*2/", "1 + 2 * 4 / 2 + 6,12+4*2/6+"})
    void convertInfixIntoPostfixTest(String infixExpression, String convertedExpression) {
        // given
        String[] infixValues = infixExpression.split(DELIMITER);
        // when
        String postfixExpression = NotationUtils.convertInfixIntoPostfix(infixValues).toString();
        // then
        assertThat(postfixExpression).isEqualTo(convertedExpression);
    }

    @DisplayName("중위 수식이 후위 수식이 담긴 스택 자료형으로 변환되는지 확인")
    @ParameterizedTest
    @CsvSource({"2 + 3 * 4 / 2,23+4*2/", "1 + 2 * 4 / 2 + 6,12+4*2/6+"})
    void convertStackForInfixIntoPostfixTest(String infixExpression, String convertedExpression) {
        // given
        String[] infixValues = infixExpression.split(DELIMITER);
        // when
        Stack<String> postfixStack = NotationUtils.convertPostfixStack(infixValues);
        String postfixExpression = convertStackToExpression(postfixStack);
        // then
        assertThat(postfixExpression).isEqualTo(convertedExpression);
    }

    private String convertStackToExpression(Stack<String> stack) {
        StringBuilder expression = new StringBuilder();
        while (!stack.isEmpty()) {
            expression.append(stack.pop());
        }
        return expression.toString();
    }
}
