package domain.vo;

import domain.Operand;
import domain.Operation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static domain.Operation.DIVISION;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@DisplayName("연산자 테스트")
class OperationTest {

    static Stream<Arguments> operations() {
        return Stream.of(
                Arguments.of(new Operand(1), Operation.PLUS, new Operand(3), new Operand(4)),
                Arguments.of(new Operand(3), Operation.SUBTRACT, new Operand(2), new Operand(1)),
                Arguments.of(new Operand(2), Operation.MULTIPLICATION, new Operand(3), new Operand(6)),
                Arguments.of(new Operand(6), DIVISION, new Operand(3), new Operand(2))
        );
    }

    @DisplayName("+, -, *, / 에따라 입력값, 피연산자에 대한 계산결과를 반환한다.")
    @MethodSource("operations")
    @ParameterizedTest
    void operation(Operand input, Operation operation, Operand operand, Operand expected) {
        assertThat(operation.operate(input, operand)).isEqualTo(expected);
    }

    @DisplayName("0으로 나누기를 시도하면 익셉션을 던진다")
    @Test
    void divideWithZero() {
        //given
        Operand input = new Operand(5);
        Operand operand = new Operand(0);

        //when //then
        assertThatThrownBy(() -> Operation.DIVISION.operate(input, operand))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0으로 나눌 수 없습니다.");
    }

    @DisplayName("+, -, *, / 외 다른 연산자가 들어오면 익셉션을 던진다")
    @ValueSource(strings = {"=", "123", "@"})
    @ParameterizedTest
    void findByInput(String wrongInput) {
        assertThatThrownBy(() -> Operation.findByType(wrongInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("%s는 올바른 연산자가 아닙니다.", wrongInput);
    }

}
