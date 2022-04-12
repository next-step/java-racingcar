package step3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.car.Car;

@DisplayName("Car 테스트")
public class CarTest {

    private Car car;

    @BeforeEach
    void init() {
        car = Car.of();
    }

    @Test
    @DisplayName("1회 이동")
    void moveTest() {
        // when
        car.move(true);
        // then
        assertThat(car.getState()).isOne();
    }

    @Test
    @DisplayName("이동 안 함")
    void moveNTimesTest() {
        // when
        car.move(false);
        // then
        assertThat(car.getState()).isZero();
    }
}
