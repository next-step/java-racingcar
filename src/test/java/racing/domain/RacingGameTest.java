package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    @DisplayName("자동차 게임을 진행하면 자동차가 위치가 이동된다")
    void play() {
        Cars cars = Cars.create(new String[]{"pobi", "crong", "honux"});

        RacingGame racingGame = new RacingGame(cars, 5);
        racingGame.play();
        assertThat(cars.getCars().get(0).getPosition() > 1);
        assertThat(cars.getCars().get(1).getPosition() > 1);
    }
}
