package racingCarGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {
    @Test
    @DisplayName("AlwaysMoveStrategy 패턴은 항상 차를 움직인다.")
    void moveByAlwaysMoveStrategy() {
        Car car = new Car("owner", new AlwaysMoveStrategy());
        car.move();
        assertThat(car.getDistance()).isEqualTo(1);
    }
}
