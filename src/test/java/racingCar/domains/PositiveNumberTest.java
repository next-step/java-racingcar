package racingCar.domains;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositiveNumberTest {

    @DisplayName("생성자 매개변수에 음수를 받을 경우 IllegalArgumentException 발생")
    @Test
    void negativeParameterThrowException() {
        assertThatThrownBy(() -> {
            new PositiveNumber(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
