package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.random.RandomNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    @DisplayName("자동차 이름은 최대 5글자를 넘을 수 없다.")
    void testTooLongCarName() {
        assertThatThrownBy(() -> new RacingCar(overThresholdGenerator, "여섯글자이다"))
            .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("5글자 이내의 자동차 이름을 넣으면 RacingCar 객체가 생성된다.")
    void testCarName() {
        final RacingCar racingCar = new RacingCar(overThresholdGenerator, "1번자동차");

        assertThat(racingCar.name()).isEqualTo("1번자동차");
    }

    @Test
    @DisplayName("임계값 이상의 숫자를 넘기면 레이싱카는 움직인다.")
    void testMove() {
        final RacingCar racingCar = new RacingCar(overThresholdGenerator, "1번자동차");

        racingCar.move();
        racingCar.move();

        assertThat(racingCar.currentPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("임계값 이하의 숫자를 넘기면 레이싱카는 움직이지 않는다.")
    void testNotMove() {
        final RacingCar racingCar = new RacingCar(underThresholdGenerator, "2번자동차");

        racingCar.move();

        assertThat(racingCar.currentPosition()).isEqualTo(0);
    }
}