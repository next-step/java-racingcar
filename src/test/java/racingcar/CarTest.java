package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @Test
    void 자동차_초기_위치_테스트() {
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 자동차_이동_테스트() {
        car.move(true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차_이동_불가_테스트() {
        car.move(false);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
