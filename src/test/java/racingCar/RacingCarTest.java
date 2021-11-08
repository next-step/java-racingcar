package racingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.utils.NumberUtils;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarTest {

    RacingCarGame racingCarGame;
    private final static int CAR_NUMBERS = 3;
    private final static int TRY_TIMES = 5;

    @BeforeEach
    void beforeTest() {
        racingCarGame = new RacingCarGame(CAR_NUMBERS, TRY_TIMES);
    }

    @Test
    void 게임_초기화() {
        List<Car> cars = racingCarGame.setRaceCar();
        assertThat(cars.size()).isEqualTo(3);
    }

    @Test
    void 자동차_동작_테스트() {
        Car car = new Car();
        car.move();
        assertThat(car.getMoveCount()).isIn(0, 1);
    }

    @Test
    void 랜덤_숫자_생성_테스트() {
        assertThat(NumberUtils.getRandomNumber()).isBetween(0, 9);
    }
}
