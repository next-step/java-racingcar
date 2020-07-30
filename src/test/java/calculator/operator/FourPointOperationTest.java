package calculator.operator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import calculator.operator.FourPointOperation.Operation;

import static org.assertj.core.api.Assertions.assertThat;

public class FourPointOperationTest {

    @DisplayName("사칙연산자 찾기")
    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    void findOperation(String operation){
        assertThat(FourPointOperation.findOperation(operation).isPresent()).isTrue();
    }

    @DisplayName("덧셈 테스트")
    @Test
    void add() {
        assertThat(FourPointOperation.compute(2, Operation.ADD, 3)).isEqualTo(5);
    }

    @DisplayName("뺄셈 테스트")
    @Test
    void subtraction() {
        assertThat(FourPointOperation.compute(3, Operation.SUBTRACTION, 1)).isEqualTo(2);
    }

    @DisplayName("곱셈 테스트")
    @Test
    void multiplication() {
        assertThat(FourPointOperation.compute(3, Operation.MULTIPLICATION, 2)).isEqualTo(6);
    }

    @DisplayName("나눗셈 테스트")
    @Test
    void division() {
        assertThat(FourPointOperation.compute(3, Operation.DIVISION, 2)).isEqualTo(1);
    }
}
