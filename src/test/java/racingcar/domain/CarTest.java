package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    public static final int MOVING_POSITION = 1;
    public static final Car MOVING_CAR = new Car(MOVING_POSITION);

    @Test
    @DisplayName("자동차가 움직이는 기능 구현 자동차의 위치가 1 증가한다.")
    void movingCarTest_positionOneIncrease() {
        Car car = new Car();
        car.moves(() -> true);

        assertThat(car).isEqualTo(MOVING_CAR);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi"})
    @DisplayName("이름을 입력하면 자동차가 생성되고, 그 자동차가 움직인다면 해당 자동차의 위치가 1 증가한다.")
    void name(String input) {
        Car car = new Car(input);
        car.moves(() -> true);

        assertThat(car).isEqualTo(new Car(input, MOVING_POSITION));
    }
}
