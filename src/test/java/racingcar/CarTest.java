package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.FixedEngine;
import racingcar.domain.RandomEngine;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("자동차를 생성한다")
    @Test
    void createCarTest() {
        Car car = new Car(new RandomEngine());
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("자동차는 이동한다")
    @Test
    void moveCarTest() {
        Car car = new Car(new FixedEngine(5));
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("자동차는 이동하지 않는다")
    @Test
    void moveCarTestSecond() {
        Car car = new Car(new FixedEngine(3));
        car.move();
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
