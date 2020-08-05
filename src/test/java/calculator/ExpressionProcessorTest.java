package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ExpressionProcessorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우")
    void splitExpression(String expression) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            String[] arguments = ExpressionProcessor.splitExpression(expression);
        });
    }
}
