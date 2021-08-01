package Car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import static org.assertj.core.api.Assertions.*;

class RacingCarTest {
    RacingCar racingCar;

    @BeforeEach
    void setUp() {
        String[] carNames = {"pobi", "crong", "honux"};
        racingCar = new RacingCar(carNames);

    }

    @ParameterizedTest
    @CsvSource({
            "3, 3, 'pobi,crong,honux'",
            "1, 1, 'pobi'"
    })
    void 자동차대수_테스트(int inputCarCount, int carCountAnswer, String carNames) {
        System.out.println(carNames);
        String[] splitedCarName = carNames.split(",");
        racingCar = new RacingCar(splitedCarName);

        int carsSize = racingCar.getCars().size();
        assertThat(carsSize).isEqualTo(carCountAnswer);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0보다 큰 값을 입력해주세요.",
            "-1, 0보다 큰 값을 입력해주세요.",
    })
    void 자동차대수_테스트_예외발생(int carCount, String errMessage) throws IllegalAccessException {
        String[] carNames = {};
        assertThatThrownBy(() -> new RacingCar(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errMessage);
    }

    @Test
    void 우승자_테스트() {
        for (int i = 0; i < 5; i++) {
            racingCar.gameStart(new Random());
        }
        List<Car> cars = racingCar.getCars();
        List<Car> winnerList = new ArrayList<Car>();
        int maxMoveCount = 0;

        for (Car car : cars) {
            maxMoveCount = Math.max(maxMoveCount, car.getMoveCount());
        }
        for (Car car : cars) {
            if (car.getMoveCount() == maxMoveCount) {
                winnerList.add(car);
            }
        }
        assertThat(racingCar.getWinner()).isEqualTo(winnerList);
    }

}