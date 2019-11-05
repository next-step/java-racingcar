package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class CarTest {

    @DisplayName("자동차가 전진한다.")
    @Test
    void move() {
        Moveable moveableStrategy = new MustMoveStrategy();
        Car car = new Car(moveableStrategy);
        assertThat(car.move()).isTrue();
    }

    @DisplayName("자동차가 멈춘다.")
    @Test
    void stop() {
        Moveable moveableStrategy = new MustStopStrategy();
        Car car = new Car(moveableStrategy);
        assertThat(car.move()).isFalse();
    }

    @Test
    void randam() {
        Moveable moveableStrategy = new RandomStrategy();
        Car car = new Car(moveableStrategy);
    }

}
