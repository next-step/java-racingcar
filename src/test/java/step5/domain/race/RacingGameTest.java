package step5.domain.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step5.domain.car.Cars;
import step5.view.result.ResultView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RacingGameTest {

    private static final int GAME_COUNT = 1;

    @ParameterizedTest
    @DisplayName("게임이 끝난 경우 isFinished()는 true를 리턴한다")
    @CsvSource(value = {"a:b:c,5"})
    void isFinished(String input, int gameCount) {
        String[] carNames = input.split(":");

        RacingGame racingGame = new RacingGame(carNames, gameCount, new ResultView());

        racingGame.race();
        assertFalse(racingGame.isFinished());

        racingGame.race();
        assertFalse(racingGame.isFinished());

        racingGame.race();
        assertFalse(racingGame.isFinished());

        racingGame.race();
        assertFalse(racingGame.isFinished());

        racingGame.race();
        assertTrue(racingGame.isFinished());
    }

    @ParameterizedTest
    @DisplayName("우승자는 한명 이상 일 수 있다")
    @ValueSource(strings = {"a", "a,b", "a,b,c", "a,b,c,d"})
    void winnerIsMoreThanOne(String input) {
        String[] carNames = input.split(",");

        RacingGame racingGame = new RacingGame(carNames, GAME_COUNT, new ResultView());

        racingGame.race();

        Cars winnerCarsOfRace = racingGame.getWinnerCarsOfRace();
        assertThat(winnerCarsOfRace.size()).isGreaterThanOrEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다")
    @ValueSource(strings = {"a", "a,b", "a,b,c", "a,b,c,d"})
    void LetMeKnowWhoArsWinnersAfterFinishedRace(String input) {
        String[] carNames = input.split(",");

        RacingGame racingGame = new RacingGame(carNames, GAME_COUNT, new ResultView());
        racingGame.race();

        String winnersName = racingGame.getWinnersName();
        assertThat(winnersName)
                .isNotNull()
                .isNotBlank()
                .isNotEmpty();
    }
}