package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperatorReaderTest {
    @Test
    @DisplayName("더하기 연산자일 경우 더하기 연산 객체 리턴")
    void plus_operator_test() {
        OperatorReader reader = new OperatorReader();
        Operator type = reader.readOperator("+");
        assertThat(type).isInstanceOf(PlusOperator.class);
    }

    @Test
    @DisplayName("빼기 연산자일 경우 빼기 연산 객체 리턴")
    void minus_operator_test() {
        OperatorReader reader = new OperatorReader();
        Operator type = reader.readOperator("-");
        assertThat(type).isInstanceOf(MinusOperator.class);
    }

    @Test
    @DisplayName("곱하기 연산자일 경우 곱하기 연산 객체 리턴")
    void multiply_operator_test() {
        OperatorReader reader = new OperatorReader();
        Operator type = reader.readOperator("*");
        assertThat(type).isInstanceOf(MultiplyOperator.class);
    }

    @Test
    @DisplayName("나누기 연산자일 경우 나누기 연산객체 리턴")
    void divide_operator_test() {
        OperatorReader reader = new OperatorReader();
        Operator type = reader.readOperator("/");
        assertThat(type).isInstanceOf(DivideOperator.class);
    }

    @Test
    @DisplayName("없는 연산자 일때익셉션")
    void no_operator_test() {
        OperatorReader reader = new OperatorReader();
        assertThatThrownBy(() ->
                reader.readOperator("#")
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
