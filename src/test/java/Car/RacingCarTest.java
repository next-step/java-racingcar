package Car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.assertj.core.api.Assertions.*;


class RacingCarTest {
    RacingCar racingCar;

    @BeforeEach
    void setUp() {
        racingCar = new RacingCar(3, 5);
    }

    @ParameterizedTest
    @CsvSource({
            "3, 5, 3, 5",
            "1, 4, 1, 4"
    })
    void 자동차대수_테스트(int inputCarCount, int inputGameCount, int carCountAnswer, int gameCountAnswer) {
        racingCar = new RacingCar(inputCarCount, inputGameCount);

        int carCount = racingCar.getCarCount();
        assertThat(carCount).isEqualTo(carCountAnswer);

        int gameCount = racingCar.getGameCount();
        assertThat(gameCount).isEqualTo(gameCountAnswer);

        int carsSize = racingCar.getCars().size();
        assertThat(carsSize).isEqualTo(carCountAnswer);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 5, 0보다 큰 값을 입력해주세요.",
            "-1, 4, 0보다 큰 값을 입력해주세요.",
            "3, 0, 0보다 큰 값을 입력해주세요.",
            "6, -1, 0보다 큰 값을 입력해주세요.",
    })
    void 자동차대수_테스트_예외발생(int carCount, int gameCount, String errMessage) throws IllegalAccessException {
        assertThatThrownBy(() -> new RacingCar(carCount, gameCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errMessage);
    }


}