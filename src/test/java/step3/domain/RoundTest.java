package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step3.runType.TestRunStrategy;
import step3.ui.InputView;

class RoundTest {

    @ParameterizedTest
    @MethodSource("provideTestGameSettings")
    @DisplayName("한 게임의 라운드 결과의 길이는 항상 게임시작시 입력한 자동차수와 같다.")
    void round_run_(GameSetting gameSetting, int expected) {

        RacingCars cars = new RacingCars(gameSetting);

        Round roundToPlay = new Round();
        roundToPlay.start(cars, gameSetting);

        assertThat(roundToPlay.getResults().size()).isEqualTo(expected);
    }


    private static Stream<Arguments> provideTestGameSettings() {

        GameSetting carCount1Setting = getTestGameSettingWithCarCount("1");
        GameSetting carCount50Setting = getTestGameSettingWithCarCount("50");
        GameSetting carCount100Setting = getTestGameSettingWithCarCount("100");

        return Stream.of(
            Arguments.of(carCount1Setting, "1"),
            Arguments.of(carCount50Setting, "50"),
            Arguments.of(carCount100Setting, "100")
        );
    }

    private static GameSetting getTestGameSettingWithCarCount(String testCarCount) {
        String testRoundCount = "5";

        List<String> userInputs = new ArrayList<>();
        userInputs.add(testCarCount);
        userInputs.add(testRoundCount);
        return new GameSetting(userInputs, new TestRunStrategy());
    }
}