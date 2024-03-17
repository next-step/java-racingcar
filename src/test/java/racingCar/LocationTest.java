package racingCar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LocationTest {

    @Test
    @DisplayName("위치 값에 음수가 들어오면 IllegalArgumentException")
    void Location_MinusTest() {
        Assertions.assertThatThrownBy(()->new Location(-1))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
