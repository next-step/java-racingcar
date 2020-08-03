package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.calculator.Operation;
import step2.common.ExceptionMessage;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperationTest {

    @DisplayName("지정 문자열 외 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings={"&","#","!"," "})
    void input_not_symbol(String input) {
        assertThatThrownBy(() ->
                Operation.findOperation(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.SYMBOL_NOT_ARITHMETIC);
    }
}
