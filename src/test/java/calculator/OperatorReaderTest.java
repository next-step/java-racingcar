package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorReaderTest {
    @Test
    void 연산자_더하기_읽기() {
        OperatorReader reader = new OperatorReader();
        Operator type = reader.readOperator("+");
        assertThat(type).isInstanceOf(PlusOperator.class);
    }

    @Test
    void 연산자_빼기_읽기() {
        OperatorReader reader = new OperatorReader();
        Operator type = reader.readOperator("-");
        assertThat(type).isInstanceOf(MinusOperator.class);
    }

    @Test
    void 연산자_곱하기_읽기() {
        OperatorReader reader = new OperatorReader();
        Operator type = reader.readOperator("*");
        assertThat(type).isInstanceOf(MultiplyOperator.class);
    }

    @Test
    void 연산자_나누기_읽기() {
        OperatorReader reader = new OperatorReader();
        Operator type = reader.readOperator("/");
        assertThat(type).isInstanceOf(DevideOperator.class);
    }
}
