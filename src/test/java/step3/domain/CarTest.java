package step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;

    @BeforeEach
    void initCar() {
        car = new Car();
    }

    @Test
    void 자동차_객체_생성시_디폴트_거리는_0이다() {
        assertThat(car.getCarDistance()).isZero();
    }

    @Test
    void 자동차를_정상적으로_전진한다() {
        car.forwardCar();

        assertThat(car.getCarDistance()).isEqualTo(1);
    }

}