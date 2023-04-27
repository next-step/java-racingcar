package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingTest {
    @Test
    void 자동차대수및시도횟수() {
        RacingCar racing = new RacingCar("lina,duke,kris",7);

        assertAll(
                () -> assertThat(racing.getCarsCount()).isEqualTo(3),
                () -> assertThat(racing.getTryCount()).isEqualTo(7)
        );
    }

    @Test
    void 자동차이름() {
        RacingCar racing = new RacingCar("lina,duke,kris",7);

        assertAll(
                () -> assertThat(racing.getCar(0)).isEqualTo(new Car("lina")),
                () -> assertThat(racing.getCar(1)).isEqualTo(new Car("duke")),
                () -> assertThat(racing.getCar(2)).isEqualTo(new Car("kris"))
        );
    }
}