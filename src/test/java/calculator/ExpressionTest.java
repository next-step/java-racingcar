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
        List<String> tokens = expression.tokenize("3+3+3+5");

        assertThat(tokens.size()).isEqualTo(4);
        assertThat(tokens).containsExactly("+3", "+3", "+3", "+5");
    }
}