package step3;

import CarRacing.Car;
import CarRacing.MovingStrategy;
import CarRacing.RacingStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private RacingStrategy racingStrategy;
    private Car car;

    @BeforeEach
    void setUp() {
        racingStrategy = new MovingStrategy();
        car = new Car();
    }

    @Test
    @DisplayName("움직이는 테스트 진행 움직인다면 1, 움직이지 않으면 1이 나옴")
    void carMoveTest() {
        car.move(racingStrategy);
        assertThat(car.getCurrentPosition()).isIn(0, 1);
    }
}
