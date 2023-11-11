package step3.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    @Test
    void moveTest() {
        NumberGenerator numberGenerator = new MovableNumberGenerator();

        RacingCar racingCar = new RacingCar();
        assertThat(racingCar.getDistance()).isEqualTo(0);

        racingCar.move(numberGenerator);
        assertThat(racingCar.getDistance()).isEqualTo(1);
    }

    @Test
    void nonMoveTest() {
        NumberGenerator numberGenerator = new NonMovableNumberGenerator();

        RacingCar racingCar = new RacingCar();
        assertThat(racingCar.getDistance()).isEqualTo(0);

        racingCar.move(numberGenerator);
        assertThat(racingCar.getDistance()).isEqualTo(0);
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