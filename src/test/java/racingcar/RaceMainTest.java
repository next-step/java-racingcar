package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.views.InputView;

import java.util.HashMap;
import java.util.Map;

class RaceMainTest {

    @ParameterizedTest
    @CsvSource(value = {"3:5", "2:2"}, delimiter = ':')
    @DisplayName("Test for racing main")
    public void mainTest(int totalCarNum, int totalMoveCnt) {
        Map<String, Integer> racingCarInfos = new HashMap<>();
        racingCarInfos.put(InputView.KEY_TOTAL_CAR_NUM, totalCarNum);
        racingCarInfos.put(InputView.KEY_TOTAL_MOVE_CNT, totalMoveCnt);

        RaceMain raceMain = new RaceMain();
        raceMain.main(racingCarInfos);
    }

}