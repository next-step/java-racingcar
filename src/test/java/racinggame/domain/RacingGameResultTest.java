package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.random.RandomNumberGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameResultTest {
    private RandomNumberGenerator overThresholdGenerator;
    private RandomNumberGenerator underThresholdGenerator;

    @BeforeEach
    void setup() {
        this.overThresholdGenerator = () -> RacingCar.MOVE_THRESHOLD + 1;
        this.underThresholdGenerator = () -> RacingCar.MOVE_THRESHOLD - 1;
    }

    @Test
    @DisplayName("자동차 경주 후 우승자 목록을 반환 할 수 있다.")
    void testResultCars() {
        final RacingCars racingCars = RacingCars.create(
            List.of(
                new RacingCar(overThresholdGenerator, "1번자동차"),
                new RacingCar(underThresholdGenerator, "2번자동차")
            )
        );

        final RacingGameResult result = new RacingGameResult(racingCars.moves());

        assertThat(result.winners().size()).isEqualTo(1);
    }
}