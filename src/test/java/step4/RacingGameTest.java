package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step4.car.Cars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {

    private static final int GAME_COUNT = 1;

    @ParameterizedTest
    @DisplayName("자동자 경주가 끝나기 전에 우승자를 확인할 수 없다")
    @ValueSource(strings = {"a", "a,a", "a,a,a", "a,a,a,a"})
    void cantKnowBeforeRaceFinished(String input) {
        String[] carNames = input.split(",");

        RacingGame racingGame = new RacingGame(carNames, GAME_COUNT);

        assertThrows(IllegalStateException.class, racingGame::getWinnerCarsOfRace);
        assertThrows(IllegalStateException.class, racingGame::getWinnersName);
    }

    @ParameterizedTest
    @DisplayName("우승자는 한명 이상 일 수 있다")
    @ValueSource(strings = {"a", "a,a", "a,a,a", "a,a,a,a"})
    void winnerIsMoreThanOne(String input) {
        String[] carNames = input.split(",");

        RacingGame racingGame = new RacingGame(carNames, GAME_COUNT);
        racingGame.race(GAME_COUNT);

        Cars winnerCarsOfRace = racingGame.getWinnerCarsOfRace();
        assertThat(winnerCarsOfRace.size()).isGreaterThanOrEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다")
    @ValueSource(strings = {"a", "a,a", "a,a,a", "a,a,a,a"})
    void LetMeKnowWhoArsWinnersAfterFinishedRace(String input) {
        String[] carNames = input.split(",");

        RacingGame racingGame = new RacingGame(carNames, GAME_COUNT);
        racingGame.race(GAME_COUNT);

        String winnersName = racingGame.getWinnersName();
        assertThat(winnersName)
                .isNotNull()
                .isNotBlank()
                .isNotEmpty();
    }

    @ParameterizedTest
    @DisplayName("게임이 끝난 경우 isFinished()는 true를 리턴한다")
    @CsvSource(value = {"a:b:c,5"})
    void isFinished(String input, int gameCount) {
        String[] carNames = input.split(":");

        RacingGame racingGame = new RacingGame(carNames, gameCount);

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
}