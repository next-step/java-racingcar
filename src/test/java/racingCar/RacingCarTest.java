package racingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingCar.ui.ResultView;
import racingCar.utils.NumberUtils;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class RacingCarTest {

    RacingCarGame racingCarGame;
    private final static int TRY_TIMES = 5;
    private final static String CAR_NAMES = "pobi,crong,honux,min";

    @BeforeEach
    void beforeTest() {
        racingCarGame = new RacingCarGame(TRY_TIMES);
    }

    @Test
    void 자동차_리스트_생성_테스트() {
        List<Car> cars = racingCarGame.setRaceCar(CAR_NAMES.split(","));
        assertThat(cars.size()).isEqualTo(4);
    }

    @Test
    void 자동차_이름_5글자_초과_테스트() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Car car = new Car("minchoi");
                });
    }

    @Test
    void 자동차_경주_이름_출력_테스트() {
        List<Car> cars = racingCarGame.setRaceCar(CAR_NAMES.split(","));
        ResultView resultView = new ResultView();
        resultView.printCarRace(cars);
    }

    @Test
    void 자동차_동작_테스트() {
        Car car = new Car("pobi");
        car.move();
        assertThat(car.getMoveCount()).isIn(0, 1);
    }

    @Test
    void 랜덤_숫자_생성_테스트() {
        assertThat(NumberUtils.getRandomNumber()).isBetween(0, 9);
    }
}
