package step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    RacingCar[] racingCars;

    @BeforeEach
    void setUp() {
        racingCars = new RacingCar[1];
        racingCars[0] = new RacingCar("test");
    }

    @Test
    void runRoundWhenCarMovingTest() {
        RacingGame racingGame = new RacingGame(racingCars, new MovableNumberGenerator());
        RacingCar[] racingCars = racingGame.runRound();
        assertThat(racingCars[0].getDistance()).isEqualTo(1);
    }

    @Test
    void runRoundWhenCarNotMovingTest() {
        RacingGame racingGame = new RacingGame(racingCars, new NonMovableNumberGenerator());
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
