package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class OperationTest {

    @Test
    void plus() {
        Operation plus = BasicOperation.PLUS;
        assertThat(plus.apply(2, 4)).isEqualTo(6);
    }

    @Test
    void minus() {
        Operation minus = BasicOperation.MINUS;
        assertThat(minus.apply(3, 2)).isEqualTo(1);
    }

    @Test
    void times() {
        Operation minus = BasicOperation.TIMES;
        assertThat(minus.apply(2, 5)).isEqualTo(10);
    }

    @Test
    void divide() {
        Operation minus = BasicOperation.DIVIDE;
        assertThat(minus.apply(6, 2)).isEqualTo(3);
    }

    @ParameterizedTest
    @EnumSource(BasicOperation.class)
    void fromString(Operation expected) {
        Optional<Operation> actual = BasicOperation.fromString(expected.toString());
        assertThat(actual).hasValue(expected);
    }
}
