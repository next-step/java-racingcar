package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ExpressionTest {
    @Test
    @DisplayName("수식을 피연산자와 덧셈으로 구성")
    void createExpression_withPlusAndOperand() {
        String expStr = "2 + 3";
        Expression e = new Expression(expStr);
        assertThat(e).as("덧셈과 피연산자로 수식 생성 실패").isNotNull();
    }

    @ParameterizedTest
    @DisplayName("문자열에 잘못된 입력")
    @MethodSource
    void createExpression_wrongInput(String expStr, String errorMessage) {
        assertThatThrownBy(() -> {
            new Expression(expStr);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorMessage);
    }

    static Stream<Arguments> createExpression_wrongInput() {
        return Stream.of(
                arguments("2 ) 3", "Wrong operator: )"),
                arguments("+ + 3", "input string: \"+\""),
                arguments(" ", "input string: blank"),
                arguments(null, "input string: null")
        );
    }
}
