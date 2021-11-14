package racingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingCar.model.RacingCarGame;
import racingCar.model.Car;
import racingCar.view.ResultView;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class RacingCarGameTest {
    RacingCarGame racingCarGame;
    private final static int TRY_TIMES = 5;
    private final static String[] CAR_NAMES = "pobi,crong,honux,min".split(",");

    @BeforeEach
    void beforeTest() {
        racingCarGame = new RacingCarGame(CAR_NAMES, TRY_TIMES);
    }

    @Test
    void 자동차_경주_이름_출력_테스트() {
        List<Car> cars = racingCarGame.getRaceCar();
        ResultView resultView = new ResultView();
        resultView.printCarRace(cars);
    }

    @Test
    void 게임_초기화_음수_파라미터_테스트() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    RacingCarGame testRacingCarGame = new RacingCarGame(CAR_NAMES,-1);
                });
    }
}
