package step3.racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.racingcar.model.RacingCarGame;

public class RacingCarGameTest {

    @Test
    @DisplayName("RacingCarGame Settings Test")
    void givenNumberOfCarsAndNumberOfRounds_whenGameStart_thenGameSettings() {
        // given
        int numberOfCars = 3;
        int numberOfRounds = 5;

        // when
        RacingCarGame game = new RacingCarGame(numberOfCars, numberOfRounds, 3);

        // then
        assertThat(game.settings()).isEqualTo("numberOfCars: 3, numberOfRounds: 5");
    }

    @Test
    @DisplayName("RacingCarGame Result Test")
    void givenNumberOfCarsAndNumberOfRounds_whenGameStart_thenGameResult() {
        // given
        int numberOfCars = 3;
        int numberOfRounds = 5;

        // when
        RacingCarGame game = new RacingCarGame(numberOfCars, numberOfRounds);
        game.ready();
        game.start();

        // then
        assertThat(game.carStatus(1)).isEqualTo(4);
        assertThat(game.carStatus(2)).isEqualTo(3);
        assertThat(game.carStatus(3)).isEqualTo(2);
    }

}
