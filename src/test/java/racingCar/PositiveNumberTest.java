package racingCar;

import racingCar.domains.PositiveNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositiveNumberTest {

    @Test
    void negativeNumber() {
        assertThatThrownBy(() -> {
            new PositiveNumber(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
