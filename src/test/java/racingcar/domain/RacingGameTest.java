package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingGameTest {

    @Test
    @DisplayName("자동차 게임을 실행한다.")
    void startGame() {
        // given
        RacingGame racingGame = new RacingGame(new DoubleRandomService(4));
        List<RacingCar> racingCars = createRacingCars();

        // when
        List<RacingCar> result = racingGame.startSingleGame(racingCars);

        // then
        assertThat(result).isEqualTo(createExpectedRacingCars());
    }

    private List<RacingCar> createRacingCars() {
        return Arrays.asList(
                new RacingCar("tobi", 0),
                new RacingCar("pobi", 0),
                new RacingCar("k5", 0)
        );
    }

    private List<RacingCar> createExpectedRacingCars() {
        return Arrays.asList(
                new RacingCar("tobi", 1),
                new RacingCar("pobi", 1),
                new RacingCar("k5", 1)
        );
    }
}
