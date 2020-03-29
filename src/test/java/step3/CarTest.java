package step3;

import CarRacing.domain.Car;
import CarRacing.domain.MovingStrategy;
import CarRacing.domain.MustMovingStrategy;
import CarRacing.domain.RacingStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private RacingStrategy racingStrategy;
    private Car car;

    @BeforeEach
    void setUp() {
        racingStrategy = new MustMovingStrategy();
        car = new Car("jinwoo",4);
    }

    @Test
    @DisplayName("움직이는 테스트")
    void carMoveTest() {
        car.move(racingStrategy);
        assertThat(car.getCurrentPosition()).isEqualTo(5);
    }
}
