package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class OperationTest {

    @DisplayName("입력 받은 사칙연산 문자열에 해당하는 ENUM 값을 리턴한다.")
    @ParameterizedTest
    @CsvSource(value = {"+:PLUS", "-:MINUS", "*:MULTIPLE", "/:DIVIDE"}, delimiter = ':')
    void findOperation(String str, Operation operation) {
        assertThat(Operation.getOperator(str)).isEqualTo(operation);
    }

    @DisplayName("덧셈을 계산한다.")
    @Test
    void plus() {
        assertThat(Operation.PLUS.apply("+", 1, 3)).isEqualTo(4);
    }

    @DisplayName("뺄셈을 계산한다.")
    @Test
    void minus() {
        assertThat(Operation.MINUS.apply("-",20, 10)).isEqualTo(10);
    }

    @DisplayName("곱셈을 계산한다.")
    @Test
    void multiple() {
        assertThat(Operation.MULTIPLE.apply("*", 20, 10)).isEqualTo(200);
    }

    @DisplayName("나눗셈을 계산한다.")
    @Test
    void divide() {
        assertThat(Operation.DIVIDE.apply("/", 20, 10)).isEqualTo(2);
    }
}