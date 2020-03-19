package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculator {

    @DisplayName("사용자 입력 받기")
    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2"})
    public void init(String source) {
        Expression expression = new Expression(source);

        assertThat(expression.getSource()).isEqualTo(source);
    }
}
