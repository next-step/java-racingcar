package racingcar;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.movablestrategy.MoveStrategy;
import racingcar.movablestrategy.PauseStrategy;
import racingcar.movablestrategy.RandomStrategy;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @DisplayName("자동차를 생성하면 초기 위치는 0 이다.")
    @Test
    void Car_초기위치() {
        Car car = new Car(new RandomStrategy(Car.MOVE_CONDITION, 10));
        assertThat(car.currentPosition()).isZero();
    }

    @DisplayName("자동차가 전진할수있다.")
    @Test
    void Car_전진() {
        Car car = new Car(new MoveStrategy());
        car.move();
        assertThat(car.currentPosition()).isEqualTo(car.MOVE_DISTANCE);
    }

    @DisplayName("자동차가 멈춘다")
    @Test
    void Car_멈춤() {
        Car car = new Car(new PauseStrategy());
        car.move();
        assertThat(car.currentPosition()).isZero();
    }
}
