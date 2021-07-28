package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarName;
import racingcar.strategy.MovingStrategy;
import racingcar.strategy.impl.RandomBoundMovingStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTests {

    @DisplayName("차가 움직이는 상황 테스트")
    @Test
    void moveTest() {
        Car car = new Car(new CarName("test"));
        car.move(new MovingStrategy() {
            @Override
            public boolean movable() {
                return true;
            }
        });
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("차가 안 움직이는 상황 테스트")
    @Test
    void stopTest() {
        Car car = new Car(new CarName("test"));
        car.move(() -> false);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
