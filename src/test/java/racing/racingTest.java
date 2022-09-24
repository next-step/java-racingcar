package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class racingTest {

    private static final int ONE_GO_STRAIGHT = 1;
    private static final int NOT_START = 0;

    @Test
    @DisplayName("자동차가 이동할 수 있을지 판단하고 이동할 수 있다면 위치값이 증가한다.")
    void goStraight_when_isGoStraight_true() {
        Car car = new Car();
        car.resetAdvanceCondition();
        if (car.isGoStraight()) {
            car.goStraight();
            int currentLocation = car.getCurrentLocation();
            assertThat(currentLocation).isEqualTo(ONE_GO_STRAIGHT);
        }
        if (!car.isGoStraight()) {
            int currentLocation = car.getCurrentLocation();
            assertThat(currentLocation).isEqualTo(NOT_START);
        }

    }


}
