package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ExpressionTest {

    @DisplayName("입력 수식을 토큰화 할 수 있다")
    @Test
    void tokenize() {
        Expression expression = new Expression();
        List<Token> tokens = expression.tokenize("3+3+3+5");
        assertThat(tokens.size()).isEqualTo(4);
        assertThat(tokens).containsExactly(
                new Token("+", 3),
                new Token("+", 3),
                new Token("+", 3),
                new Token("+", 5)
        );
    }

    @DisplayName("두자리수 이상의 숫자도 정확히 토큰화 할 수 있다")
    @Test
    void tokenizeBigNumber() {
        Expression expression = new Expression();
        List<Token> tokens = expression.tokenize("-33+45*5/2*12");
        assertThat(tokens.size()).isEqualTo(5);
        assertThat(tokens).containsExactly(
                new Token("-", 33),
                new Token("+", 45),
                new Token("*", 5),
                new Token("/", 2),
                new Token("*", 12)
        );
    }
}