package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.strategy.impl.RandomBoundMovingStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTests {

    @DisplayName("차의 거리가 0,1 사이로 움직이는지 테스트")
    @Test
    void moveTest() {
        Car car = new Car();
        car.move(new RandomBoundMovingStrategy());
        assertThat(car.getPosition()).isBetween(0, 1);
    }
}
