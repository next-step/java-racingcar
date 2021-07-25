package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.strategy.impl.RandomBoundMovingStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTests {

    @DisplayName("차가 움직이는지 테스트")
    @Test
    void moveTest() {
        Car car = new Car();
        car.setMovingStrategy(new RandomBoundMovingStrategy());
        car.move(true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("움직이는 조건이 아닐 때 차가 움직이지 않는지 테스트")
    @Test
    void notMoveTest() {
        Car car = new Car();
        car.setMovingStrategy(new RandomBoundMovingStrategy());
        car.move(false);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
