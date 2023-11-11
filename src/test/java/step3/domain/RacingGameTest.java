package step3.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    void runRoundWhenCarMovingTest() {
        RacingGame racingGame = new RacingGame(1, new MovableNumberGenerator());
        RacingCar[] racingCars = racingGame.runRound();
        assertThat(racingCars[0].getDistance()).isEqualTo(1);
    }

    @Test
    void runRoundWhenCarNotMovingTest() {
        RacingGame racingGame = new RacingGame(1, new NonMovableNumberGenerator());
        RacingCar[] racingCars = racingGame.runRound();
        assertThat(racingCars[0].getDistance()).isEqualTo(0);
    }

    private class MovableNumberGenerator implements NumberGenerator {
        @Override
        public int generate() {
            return 4;
        }
    }

    private class NonMovableNumberGenerator implements NumberGenerator {
        @Override
        public int generate() {
            return 3;
        }
    }

}
