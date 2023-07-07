package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.MockRandom;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.Position;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    private final int canMoveValue = 4;
    private final int canNotMoveValue = 3;

    @Test
    @DisplayName("자동차가 랜덤 값이 4이상인 경우 이동한다.")
    void carTest_move() {
        Car car = new Car(new CarName("hello"), new MockRandom(canMoveValue));
        car.move();
        assertThat(car.getPosition()).isEqualTo(new Position(2));
    }

    @Test
    @DisplayName("자동차가 랜덤 값이 3 이하인 경우 이동할 수 없다.")
    void carTest_not_move() {
        Car car = new Car(new CarName("hello"), new MockRandom(canNotMoveValue));
        car.move();
        assertThat(car.getPosition()).isEqualTo(new Position(1));
    }
}
