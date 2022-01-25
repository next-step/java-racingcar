package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OperationTest {

    @Test
    public void enum_생성_확인() {
        assertThat(Operation.calculate("+", 3, 5)).isEqualTo(8);
        assertThat(Operation.calculate("-", 3, 5)).isEqualTo(-2);
        assertThat(Operation.calculate("*", 3, 5)).isEqualTo(15);
        assertThat(Operation.calculate("/", 3, 1)).isEqualTo(3);
        assertThatExceptionOfType(ArithmeticException.class)
            .isThrownBy(() -> Operation.calculate("/", 3, 0)).withMessage("[ERROR] 0으로 나눌 수 없습니다.");
    }

}