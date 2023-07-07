package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.MockRandom;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    private static final int CAN_MOVE_VALUE = 4;
    private static final int CAN_NOT_MOVE_VALUE = 3;

    @Test
    @DisplayName("자동차가 랜덤 값이 4이상인 경우 이동한다.")
    void carTest_move() {
        Car car = new Car(new CarName("hello"), new MockRandom(CAN_MOVE_VALUE));
        car.move();
        assertThat(car.getPosition()).isEqualTo(new Position(2));
    }

    @Test
    @DisplayName("자동차가 랜덤 값이 3 이하인 경우 이동할 수 없다.")
    void carTest_not_move() {
        Car car = new Car(new CarName("hello"), new MockRandom(CAN_NOT_MOVE_VALUE));
        car.move();
        assertThat(car.getPosition()).isEqualTo(new Position(1));
    }
}
