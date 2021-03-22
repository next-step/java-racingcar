package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("자동차 움직임 테스트")
    void move() {
        //given
        int START_LOCATION = 0;
        int MOVE_STRATEGY = 1;

        Name carName = new Name("abc");
        Car car = new Car(START_LOCATION, carName);

        final int expectLocation = START_LOCATION + MOVE_STRATEGY;

        //when
        car.move(true);

        //then
        assertThat(car.getCurrentLocation()).isEqualTo(expectLocation);
    }

    @Test
    @DisplayName("get 현재 위치 테스트")
    void getCurrentLocation() {
        //given
        int NOW_LOCATION = 2;
        Name carName = new Name("abc");
        Car car = new Car(NOW_LOCATION, carName);

        //when
        int resultLocation = car.getCurrentLocation();

        //then
        assertThat(resultLocation).isEqualTo(NOW_LOCATION);
    }

    @Test
    @DisplayName("이겼는지 비교하는 테스트")
    void bigger() {
        // given
        int NOW_LOCATION = 2;
        Name carName = new Name("abc");
        Car car = new Car(NOW_LOCATION, carName);

        // when
        Boolean resultTrue = car.win(1);
        Boolean resultFalse = car.win(3);

        // then
        assertThat(resultTrue).isTrue();
        assertThat(resultFalse).isFalse();

    }


}
