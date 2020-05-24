package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class OperandTest {

    @DisplayName("피연산자 생성")
    @ParameterizedTest
    @ValueSource(ints = {1, 100, 4000, 7777})
    void operand(final int value) {
        assertThat(Operand.of(value).getValue()).isEqualTo(value);
    }

    @DisplayName("피연산자가 Null 또는 공백 문자일 때, throw IllegalArgumentException 를 실행")
    @ParameterizedTest
    @NullAndEmptySource
    void throwExceptionIfNullAndEmptyValue(final String value) {
        assertThatThrownBy(() -> Operand.of(value))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Null 또는 공백 문자는 피연산자가 될 수 없습니다.");
    }
}