package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    private static final int NOT_START = 0;
    private static final int ONE_GO_STRAIGHT = 1;
    private static final String NORMAL_NAME = "TEST";

    @Test
    @DisplayName("자동차가 이동할 수 있을지 판단하고 True라면 위치값이 증가한다.")
    void goStraight_when_isGoStraight_true() {
        Car car = new Car(0, NORMAL_NAME);
        car.goStraight(() -> true);
        final int curLocation = car.getCurrentLocation();

        assertThat(curLocation).isEqualTo(ONE_GO_STRAIGHT);
    }

    @Test
    @DisplayName("자동차가 이동할 수 있을지 판단하고 False라면 위치값이 그대로 머물게 된다.")
    void goStraight_when_isGoStraight_false() {
        Car car = new Car(0, NORMAL_NAME);
        car.goStraight(() -> false);
        final int curLocation = car.getCurrentLocation();
        assertThat(curLocation).isEqualTo(NOT_START);
    }

    @Test
    @DisplayName("자동차 이름이 같더라도  위치가 다르면 다른 객체로 판단한다.")
    void sameNameAndDifferentLocationIsDifferentCar() {
        Car car = new Car(0, NORMAL_NAME);
        Car car2 = new Car(1, NORMAL_NAME);
        assertThat(car).isNotEqualTo(car2);
    }

    @Test
    @DisplayName("자동차 이름과 위치가 같다면 같은 객체로 판단한다.")
    void sameNameAndSameocationIsEqualCar() {
        Car car = new Car(0, NORMAL_NAME);
        Car car2 = new Car(0, NORMAL_NAME);
        assertThat(car).isEqualTo(car2);
    }
}
