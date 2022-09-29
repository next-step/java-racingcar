package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.model.Car;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    private static final int NOT_START = 0;
    private static final int ONE_GO_STRAIGHT = 1;
    private static final String OVER_FIVE_IN_LENGTH = "123456";
    private static final String BLANK = "";
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
    @DisplayName("자동차를 생성할 때 5자를 초과할 경우 에러를 발생한다.")
    void constructorTestOverFiveinLengthError() {
        assertThatThrownBy(() -> new Car(0, OVER_FIVE_IN_LENGTH)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차를 생성할 때 빈값을 넣을 경우 에러를 발생한다.")
    void constructorTestBlank() {
        assertThatThrownBy(() -> new Car(0, BLANK)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차를 생성할 때 Null을 넣을 경우 에러를 발생한다.")
    void constructorTestNull() {
        assertThatThrownBy(() -> new Car(0, null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 같더라도 다른 객체로 판단한다.")
    void sameNameButDifferentCar() {
        Car car = new Car(0, NORMAL_NAME);
        Car car2 = new Car(0, NORMAL_NAME);
        assertThat(car).isNotEqualTo(car2);
    }

}
