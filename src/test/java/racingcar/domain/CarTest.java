package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    @DisplayName("자동차 움직임 테스트")
    void move() {
        //given

        final int START_LOCATION = 0;
        final int MOVE_STRATEGY = 1;
        final int expectLocation = START_LOCATION + MOVE_STRATEGY;
        Car car = new Car(START_LOCATION);

        //when
        car.move(true);

        //then
        assertThat(car.getCurrentLocation()).isEqualTo(expectLocation);
    }

    @Test
    @DisplayName("get 현재 위치 테스트")
    void getCurrentLocation() {
        //given
        final int NOW_LOCATION = 2;
        Car car = new Car(NOW_LOCATION);

        //when
        int expectLocation = car.getCurrentLocation();
        //then
        assertThat(expectLocation).isEqualTo(NOW_LOCATION);
    }

    @Test
    @DisplayName("현재 위치를 표현하는 방법")
    void getLocationToExpression() {
        //given
        final int NOW_LOCATION = 2;
        Car car = new Car(NOW_LOCATION);
        final String expectLocation = "--";

        //when
        String resultLocation = car.getLocationToExpression();

        //then
        assertThat(resultLocation).isEqualTo(expectLocation);
    }


}
