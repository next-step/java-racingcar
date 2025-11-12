package study.racing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarPositionTest {

    @Test
    void 자동차위치의_초기값은_0이다() {
        CarPosition carPosition = new CarPosition();
        assertThat(carPosition.getValue()).isZero();
    }

    @Test
    void 자동차위치를_증가시키면_증가된_자동차위치를_반환한다() {
        CarPosition increasedCarPosition = new CarPosition().increase();

        assertThat(increasedCarPosition.getValue()).isEqualTo(1);
    }

    @Test
    void 같은_위치이면_동등성을_가진다() {
        CarPosition carPosition1 = new CarPosition();
        CarPosition carPosition2 = new CarPosition();

        assertThat(carPosition1).isEqualTo(carPosition2);
    }
}
