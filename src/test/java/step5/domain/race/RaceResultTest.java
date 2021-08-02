package step5.domain.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step5.domain.car.Cars;

import static org.assertj.core.api.Assertions.assertThat;

class RaceResultTest {

    private static final int GAME_COUNT = 1;

    @ParameterizedTest
    @DisplayName("우승자는 한명 이상 일 수 있다")
    @ValueSource(strings = {"a", "a,b", "a,b,c", "a,b,c,d"})
    void winnerIsMoreThanOne(String input) {
        String[] carNames = input.split(",");

        RacingGame racingGame = new RacingGame(carNames, GAME_COUNT);

        RaceResult raceResult = racingGame.race();
        raceResult.printProgressOfRace();

        Cars winnerCarsOfRace = raceResult.getWinnerCarsOfRace();

        assertThat(winnerCarsOfRace.size()).isGreaterThanOrEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다")
    @ValueSource(strings = {"a", "a,b", "a,b,c", "a,b,c,d"})
    void LetMeKnowWhoArsWinnersAfterFinishedRace(String input) {
        String[] carNames = input.split(",");

        RacingGame racingGame = new RacingGame(carNames, GAME_COUNT);

        RaceResult raceResult = racingGame.race();
        raceResult.printProgressOfRace();

        String winnersName = raceResult.getWinnersName();
        assertThat(winnersName)
                .isNotNull()
                .isNotBlank()
                .isNotEmpty();
    }
}