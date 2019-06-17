package calculator.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class OperationSymbolTest {

    @Test
    @DisplayName("OperationSymbol 변환 테스트")
    void from() {
        List<String> supportedOperations = Arrays.asList("+", "-", "*", "/");
        supportedOperations.forEach(operation ->
                    assertThatCode(() -> OperationSymbol.from(operation)).doesNotThrowAnyException());

        List<String> unsupportedOperations = Arrays.asList("%", ",", ".", "&", "!");
        unsupportedOperations.forEach(operation ->
                      assertThatExceptionOfType(UnsupportedOperationException.class).isThrownBy(() -> OperationSymbol.from(operation)));

    }
}