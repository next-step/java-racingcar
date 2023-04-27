package step2;

import org.junit.jupiter.api.Test;
import step2.racing_mvc.domain.RacingCar;
import step2.racing_mvc.domain.RacingGame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class RacingTest {
    @Test
    void 자동차대수및시도횟수() {
        RacingGame racing = new RacingGame("pobi,crong,honux",7);

        assertAll(
                () -> assertThat(racing.getCarsCount()).isEqualTo(3),
                () -> assertThat(racing.getTryCount()).isEqualTo(7)
        );
    }

    @Test
    void 자동차이름() {
        RacingGame racing = new RacingGame("pobi,crong,honux",7);

        assertAll(
                () -> assertThat(racing.getCar(0)).isEqualTo(new RacingCar("pobi")),
                () -> assertThat(racing.getCar(1)).isEqualTo(new RacingCar("crong")),
                () -> assertThat(racing.getCar(2)).isEqualTo(new RacingCar("honux"))
        );
    }
}