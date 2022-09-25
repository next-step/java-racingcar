package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.model.Car;

import static org.assertj.core.api.Assertions.*;

public class racingTest {

    private static final int ONE_GO_STRAIGHT = 1;
    private static final int NOT_START = 0;

    @Test
    @DisplayName("자동차가 이동할 수 있을지 판단하고 True라면 위치값이 증가한다.")
    void goStraight_when_isGoStraight_true() {
        Car car = new Car();
        car.goStraight(() -> true);
        final int curLocation = car.getCurrentLocation();

        assertThat(curLocation).isEqualTo(ONE_GO_STRAIGHT);
    }

    @Test
    @DisplayName("자동차가 이동할 수 있을지 판단하고 False라면 위치값이 그대로 머물게 된다.")
    void goStraight_when_isGoStraight_false() {
        Car car = new Car();
        car.goStraight(() -> false);
        final int curLocation = car.getCurrentLocation();
        assertThat(curLocation).isEqualTo(NOT_START);
    }

}
