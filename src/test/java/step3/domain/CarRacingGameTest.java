package step3.domain;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.runType.TestRunStrategy;
import step3.ui.InputView;

class CarRacingGameTest {

    @ParameterizedTest
    @CsvSource(value = {"3,5,3,5", "5,7,5,7", "100,135,100,135"}, delimiter = ',')
    @DisplayName("테스트 운행시, 입력받은 자동차 대수와 시도회수에 의해 일정한 게임결과를 얻는다. ")
    void testRacingGamePlay(int carCount, int roundCount,
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


    private static GameSetting getTestGameSettingWithCarCountAndRoundCount(int carCount,
        int roundCount) {
        Map<String, Integer> userInputs = new HashMap<>();
        userInputs.put(InputView.CAR_COUNT_KEY, carCount);
        userInputs.put(InputView.ROUND_COUNT_KEY, roundCount);
        return new GameSetting(userInputs, new TestRunStrategy());
    }
}