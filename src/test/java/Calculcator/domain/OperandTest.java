package Calculcator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperandTest {

    @DisplayName("Operand는 수식에 참여하는 피연산자를 포장한다.")
    @ParameterizedTest
    @ValueSource(doubles = {0, 1, -1, 4})
    void operand(double value) {
        Operand operand = new Operand(value);
        assertThat(operand.getValue()).isEqualTo(value);
    }

    @DisplayName("Operand는 String 타입을 double 타입으로 캐스팅하여 값을 포장한다.")
    @ParameterizedTest
    @CsvSource({"102, 102", "-10, -10", "0, 0"})
    void operandWithString(String stringValue, double value) {
        Operand operand = new Operand(stringValue);
        assertThat(operand.getValue()).isEqualTo(value);
    }

    @DisplayName("null 또는 공백이 들어오면 IllegalArgumentException을 throw 한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void nullOperandThrowsException(String value) {
        assertThatThrownBy(() -> new Operand(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Null 또는 공백 문자는 피연산자가 될 수 없습니다.");
    }

    @DisplayName("피연산자가 아닌 String 값이 들어오면 IllegalArgumentException을 throw 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"abc", "+", "a1zs"})
    void wrongOperandThrowsException(String value) {
        assertThatThrownBy(() -> new Operand(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 피연산자가 아닙니다. - " + value);
    }
}
