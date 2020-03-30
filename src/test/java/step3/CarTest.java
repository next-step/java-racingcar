package step3;

import CarRacing.domain.Car;
import CarRacing.domain.MustMovingStrategy;
import CarRacing.domain.NonMovingStrategy;
import CarRacing.domain.RacingStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private RacingStrategy mustMovingStrategy;
    private RacingStrategy nonMovingStrategy;
    private Car car;

    @BeforeEach
    void setUp() {
        mustMovingStrategy = new MustMovingStrategy();
        nonMovingStrategy = new NonMovingStrategy();
        car = new Car("jinwoo", 4);
    }

    @Test
    @DisplayName("움직이는 테스트")
    void carMoveTest() {
        car.move(mustMovingStrategy);
        assertThat(car.getCurrentPosition()).isEqualTo(5);
    }

    @Test
    @DisplayName("움직이지 않는 테스트")
    void carStopTest() {
        car.move(nonMovingStrategy);
        assertThat(car.getCurrentPosition()).isEqualTo(4);
    }
}
