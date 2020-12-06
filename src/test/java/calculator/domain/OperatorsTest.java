package calculator.domain;


import calculator.domain.Operators;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class OperatorsTest {

    @DisplayName("사칙연산 유효성 체크")
    @ParameterizedTest
    @ValueSource(strings = {"1 + 2", "1 + 2 + 3"})
    void validOperators(String input) {
        String[] inputs = input.split(" ");
        new Operators(inputs);
    }

    @DisplayName("사칙연산 넬 체크")
    @ParameterizedTest
    @NullAndEmptySource()
    void validNullOperators(String[] input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Operators(input);
        })
                .withMessageContaining("입력 값이 없습니다.");
    }

    @Test
    @DisplayName("사칙연산 아닐 경우 예외 처리")
    void notOperatorException() {
        String[] inputs = {"1","+","3"};
        new Operators(inputs);
        String[] inputs2 = {"1","+","3","-"};
        new Operators(inputs2);
        String[] inputs3 = {"1","%","3","@"};
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Operators op = new Operators(inputs3);
        })
                .withMessageContaining("사칙연산 기호가 올바르지 않습니다.");
    }

}
