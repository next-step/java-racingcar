package step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step3.service.RacingCarForwardMatcher;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;

    @BeforeEach
    void initCar() {
        car = new Car(new RacingCarForwardMatcher());
    }

    @Test
    void 자동차_객체_생성시_디폴트_거리는_0이다() {
        assertThat(car.getCarDistance()).isZero();
    }

    @Test
    void 랜덤값이_4이상일경우_자동차가_전진한다() {
        final int random = 5;

        car.forward(random);

        assertThat(car.getCarDistance()).isEqualTo(1);
    }

    @Test
    void 랜덤값이_4미만일경우_자동차는_멈춰있다() {
        final int random = 3;

        car.forward(random);

        assertThat(car.getCarDistance()).isEqualTo(0);
    }

}