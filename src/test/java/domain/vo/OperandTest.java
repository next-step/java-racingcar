package domain.vo;

import domain.Operand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class OperandTest {

    static Stream<Arguments> nullOrBlank() {
        return Stream.of(
                Arguments.of((Object) null),
                Arguments.of(""),
                Arguments.of(" "),
                Arguments.of("  ")
        );
    }

    @DisplayName("숫자가 아닌 값으로 Operand 생성을 시도하면 익셉션을 던진다")
    @ValueSource(strings = {"@", ",", "aaaa", "ㄱㅏ", "-"})
    @ParameterizedTest
    void operand(String wrongValue) {
        assertThatThrownBy(() -> new Operand(wrongValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("%s는 숫자로 변환할 수 없습니다", wrongValue);
    }

    @DisplayName("null또는 공백으로 Operand 초기화를 시도하면 익셉션을 던진다")
    @MethodSource("nullOrBlank")
    @ParameterizedTest
    void operandByNull(Object input) {
        assertThatThrownBy(() -> new Operand((String) input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("null또는 빈 공백문자는 Operand로 변환할 수 없습니다");
    }
}
