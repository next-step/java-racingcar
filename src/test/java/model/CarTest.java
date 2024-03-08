package model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 랜덤_값이_4이상이면_전진한다() {
        // given
        final int randomNumber = 4;
        final Car car = new Car();

        // when
        car.move(randomNumber);

        // then
        assertThat(car.getLocation()).isEqualTo(1);
    }
}
