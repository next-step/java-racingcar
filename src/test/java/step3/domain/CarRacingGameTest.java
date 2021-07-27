package step3.domain;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step3.runType.TestRunStrategy;

class CarRacingGameTest {

    private static final char PROGRESS_CHAR = '-';


    @ParameterizedTest
    @MethodSource("provideTestGameSettings")
    @DisplayName("테스트 운행시, 입력받은 자동차 대수와 시도회수에 의해 일정한 게임결과를 얻는다. ")
    void testRacingGamePlay(GameSetting testGameSetting) {

        CarRacingGame carRacingGame = new CarRacingGame(testGameSetting);
        carRacingGame.gameStart();

        CarRacingGameResult gameResult = carRacingGame.getCarRacingGameResult();
        List<Round> playedRounds = gameResult.getPlayedRounds();

        Round finalRound = playedRounds.get(playedRounds.size() - 1);

        assertThat(playedRounds.size()).isEqualTo(testGameSetting.getRoundCount());
        assertThat(finalRound.getCarRunResults().size()).isEqualTo(testGameSetting.getCarCount());

        for (CarRunResult result : finalRound.getCarRunResults()) {
            long progressCount = countCharInString(result.generateCarRunResultString(), PROGRESS_CHAR);
            assertThat(progressCount).isEqualTo(testGameSetting.getRoundCount());
        }

    }

    private static Stream<Arguments> provideTestGameSettings() {

        String carNameString1 = "car1";
        String carNameString2 = "car1,car2,car3";
        String carNameString3 = "car1,car2,car3, car4, car5";

        String testRoundCount1 = "1";
        String testRoundCount2 = "50";
        String testRoundCount3 = "100";

        GameSetting testGameSetting1 = getTestGameSetting(carNameString1, testRoundCount1);
        GameSetting testGameSetting2 = getTestGameSetting(carNameString2, testRoundCount2);
        GameSetting testGameSetting3 = getTestGameSetting(carNameString3, testRoundCount3);

        return Stream.of(
            Arguments.of(testGameSetting1),
            Arguments.of(testGameSetting2),
            Arguments.of(testGameSetting3)
        );
    }

    private static GameSetting getTestGameSetting(String testCarNames, String testRoundCount) {

        List<String> userInputs = new ArrayList<>();
        userInputs.add(testCarNames);
        userInputs.add(testRoundCount);
        return new GameSetting(userInputs, new TestRunStrategy());
    }

    private long countCharInString(String string, char c) {

        long count = string.chars().filter(ch -> ch == c).count();

        return count;
    }

}