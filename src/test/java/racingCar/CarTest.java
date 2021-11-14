package racingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingCar.model.RacingCarGame;
import racingCar.model.Car;
import racingCar.model.RandomMoveStrategy;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class CarTest {

    RacingCarGame racingCarGame;
    private final static int TRY_TIMES = 5;
    private final static String[] CAR_NAMES = "pobi,crong,honux,min".split(",");

    @BeforeEach
    void beforeTest() {
        racingCarGame = new RacingCarGame(CAR_NAMES, TRY_TIMES);
    }

    @Test
    void 자동차_리스트_생성_테스트() {
        List<Car> cars = racingCarGame.getRaceCar();
        assertThat(cars.size()).isEqualTo(4);
    }

    @Test
    void 자동차_이름_5글자_초과_테스트() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Car car = new Car("minchoi", new RandomMoveStrategy());
                });
    }

    @Test
    void 자동차_동작_테스트() {
        Car car = new Car("pobi",  new RandomMoveStrategy());
        // 어떤 식으로 True / False를 나눠야 할지 잘 모르겠음.
    }
}
