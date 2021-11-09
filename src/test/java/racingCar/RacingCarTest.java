package racingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingCar.utils.NumberUtils;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarTest {

    RacingCarGame racingCarGame;
    private final static int TRY_TIMES = 5;

    @BeforeEach
    void beforeTest() {
        racingCarGame = new RacingCarGame(TRY_TIMES);
    }

    @Test
    void 자동차_리스트_생성_테스트() {
        String[] names = "pobi,crong,honux,minchoi".split(",");
        List<Car> cars = racingCarGame.setRaceCar(names);
        assertThat(cars.size()).isEqualTo(4);
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
