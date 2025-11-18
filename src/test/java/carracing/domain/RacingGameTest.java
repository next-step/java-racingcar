package carracing.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {
    @Test
    @DisplayName("게임결과")
    void play() {
        RacingGame racingGame = new RacingGame("kim,lee", 3);
        racingGame.play();
        List<RacingCar> racingCars = racingGame.getRacingCars();
        for (RacingCar racingCar : racingCars) {
            assertThat(racingCar.getPosition().value()).isBetween(0, 1);
        }
    }

    @Test
    @DisplayName("횟수가 남아있다")
    void playIsEnd() {
        RacingGame racingGame = new RacingGame("kim,lee", 3);
        racingGame.play();
        assertThat(racingGame.isEnd()).isTrue();
    }
}