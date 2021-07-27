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

class RoundTest {

    @ParameterizedTest
    @MethodSource("provideTestGameSettings")
    @DisplayName("한 게임의 라운드 결과의 길이는 항상 게임시작시 입력한 자동차수와 같다.")
    void round_run_(GameSetting gameSetting) {

        RacingCars cars = new RacingCars(gameSetting);

        Round roundToPlay = new Round();
        roundToPlay.start(cars, gameSetting);

        assertThat(roundToPlay.getCarRunResults().size()).isEqualTo(gameSetting.getCarCount());
    }


    private static Stream<Arguments> provideTestGameSettings() {

        String carNameString1 = "car1";
        String carNameString2 = "car1,car2,car3";
        String carNameString3 = "car1,car2,car3, car4, car5";

        GameSetting carCount1Setting = getTestGameSettingWithCarNames(carNameString1);
        GameSetting carCount50Setting = getTestGameSettingWithCarNames(carNameString2);
        GameSetting carCount100Setting = getTestGameSettingWithCarNames(carNameString3);

        return Stream.of(
            Arguments.of(carCount1Setting),
            Arguments.of(carCount50Setting),
            Arguments.of(carCount100Setting)
        );
    }

    private static GameSetting getTestGameSettingWithCarNames(String testCarNames) {
        String testRoundCount = "5";

        List<String> userInputs = new ArrayList<>();
        userInputs.add(testCarNames);
        userInputs.add(testRoundCount);
        return new GameSetting(userInputs, new TestRunStrategy());
    }

}