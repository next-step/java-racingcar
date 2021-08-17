package calulator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {
    @Test
    void operatorTest() {
        assertThat(Operator.find("+")).isEqualTo(Operator.PLUS);
    }

    @Test
    void operatorTest1() {
        assertThat(Operator.find("-")).isEqualTo(Operator.MINUS);
    }

    @Test
    void operatorTest2() {
        assertThat(Operator.find("*")).isEqualTo(Operator.MULTIPLY);
    }

    @Test
    void operatorTest3() {
        assertThat(Operator.find("/")).isEqualTo(Operator.SUBTRACT);
    }

    @Test
    void operatorTest4() {
        assertThat(Operator.PLUS.calculate(1, 2)).isEqualTo(3);
    }

    @Test
    void operatorTest5() {
        assertThat(Operator.MINUS.calculate(2, 1)).isEqualTo(1);
    }

    @Test
    void operatorException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Operator.SUBTRACT.calculate(2, 0));
    }
}