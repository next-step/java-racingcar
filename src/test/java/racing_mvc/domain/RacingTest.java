package racing_mvc.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingTest {
    @Test
    void 자동차대수및시도횟수() {
        Racing racing = new Racing("pobi,crong,honux",7);

        assertAll(
                () -> assertThat(racing.getCarsCount()).isEqualTo(3),
                () -> assertThat(racing.getTryCount()).isEqualTo(7)
        );
    }

    @Test
    void 자동차이름() {
        Racing racing = new Racing("pobi,crong,honux",7);

        assertAll(
                () -> assertThat(racing.getCar(0)).isEqualTo(new Car("pobi")),
                () -> assertThat(racing.getCar(1)).isEqualTo(new Car("crong")),
                () -> assertThat(racing.getCar(2)).isEqualTo(new Car("honux"))
        );
    }
}