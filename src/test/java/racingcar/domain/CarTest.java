package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    @DisplayName("자동차가 조건에 맞으면 이동한다.")
    void carTest_move() {
        Car car = new Car(new CarName("hello"), new Position());
        car.move(() -> true);
        assertThat(car.getPosition()).isEqualTo(new Position(2));
    }

    @Test
    @DisplayName("자동차가 조건에 맞지 않으면 이동할 수 없다.")
    void carTest_not_move() {
        Car car = new Car(new CarName("hello"), new Position());
        car.move(() -> false);
        assertThat(car.getPosition()).isEqualTo(new Position(1));
    }
}
