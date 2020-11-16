package step5.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RacingCarControllerTest {

    String[] carNames = "zu,cu,du".split(",");

    @Test
    @DisplayName("입력한 자동차 갯수 일치 확인")
    public void 입력한_자동차_갯수_일치_확인() {
        RacingCarController racingCarController = RacingCarController.of(carNames, 4);
        racingCarController.gameProgress();
        assertEquals(carNames.length, racingCarController.getCars().size());
    }

    @Test
    @DisplayName("입력한 자동차 값이 정상 등록되는지")
    public void 등록_자동차_확인() {
        RacingCarController racingCarController = RacingCarController.of(carNames, 4);
        assertEquals(racingCarController.getCars().get(0).getCarName(), "zu");
        assertEquals(racingCarController.getCars().get(1).getCarName(), "cu");
        assertEquals(racingCarController.getCars().get(2).getCarName(), "du");
    }

    @ParameterizedTest
    @DisplayName("마지막 게임인 경우 true")
    @ValueSource(ints = {1, 3, 7})
    public void 마지막_게임_확인(int values) {
        RacingCarController racingCarController = RacingCarController.of(carNames, values);
        IntStream.range(0, values)
                .forEach(i -> racingCarController.gameProgress());
        assertTrue(racingCarController.isFinish());
    }
}
