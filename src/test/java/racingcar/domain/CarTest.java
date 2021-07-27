package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car(new CarName("pobi"));
    }

    @DisplayName("이동 조건을 만족하면 자동차는 전진한다.")
    @Test
    void move() {
        car.move(() -> true);
        assertThat(car.getCarPosition()).isEqualTo(1);
    }

    @DisplayName("이동 조건을 만족하지 않으면 자동차는 이동하지 않는다.")
    @Test
    void stop() {
        car.move(() -> false);
        assertThat(car.getCarPosition()).isZero();
    }

}
