package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.random.RandomNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {
    private RandomNumberGenerator overThresholdGenerator;
    private RandomNumberGenerator underThresholdGenerator;

    @BeforeEach
    void setup() {
        this.overThresholdGenerator = new RandomNumberGenerator() {
            @Override
            public int generate() {
                return RacingCar.MOVE_THRESHOLD + 1;
            }
        };

        this.underThresholdGenerator = new RandomNumberGenerator() {
            @Override
            public int generate() {
                return RacingCar.MOVE_THRESHOLD - 1;
            }
        };
    }

    @Test
    @DisplayName("임계값 이상의 숫자를 넘기면 레이싱카는 움직인다.")
    void testMove() {
        final RacingCar racingCar = new RacingCar(overThresholdGenerator);
        racingCar.move();
        racingCar.move();
        assertThat(racingCar.currentPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("임계값 이하의 숫자를 넘기면 레이싱카는 움직이지 않는다.")
    void testNotMove() {
        final RacingCar racingCar = new RacingCar(underThresholdGenerator);
        racingCar.move();
        assertThat(racingCar.currentPosition()).isEqualTo(0);
    }
}