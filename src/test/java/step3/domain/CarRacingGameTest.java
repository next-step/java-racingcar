package step3.domain;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.runType.TestRunStrategy;

class CarRacingGameTest {

    @ParameterizedTest
    @CsvSource(value = {"3,5,3,5", "5,7,5,7", "100,135,100,135"}, delimiter = ',')
    @DisplayName("테스트 운행시, 입력받은 자동차 대수와 시도회수에 의해 일정한 게임결과를 얻는다. ")
    void testRacingGamePlay(String carCount, String roundCount,
        int expectedCarCount, int expectedRoundCount) {
        GameSetting testGameSetting = getTestGameSettingWithCarCountAndRoundCount(
            carCount, roundCount);

        CarRacingGame carRacingGame = new CarRacingGame(testGameSetting);
        carRacingGame.gameStart();
        List<Round> playedRounds = carRacingGame.getPlayedRounds();

        Round finalRound = playedRounds.get(playedRounds.size() - 1);

        assertThat(playedRounds.size()).isEqualTo(expectedRoundCount);
        assertThat(finalRound.getResults().size()).isEqualTo(expectedCarCount);
        assertThat(finalRound.getResults()).containsOnly(expectedRoundCount);

    }


    private static GameSetting getTestGameSettingWithCarCountAndRoundCount(String carCount,
        String roundCount) {
        List<String> userInputs = new ArrayList<>();
        userInputs.add(carCount);
        userInputs.add(roundCount);
        return new GameSetting(userInputs, new TestRunStrategy());
    }
}