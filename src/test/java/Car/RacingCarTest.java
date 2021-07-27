package Car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class RacingCarTest {
    RacingCar racingCar;

    @BeforeEach
    void setUp() {
        racingCar = new RacingCar(3);
    }

    @ParameterizedTest
    @CsvSource({
            "3, 3",
            "1, 1"
    })
    void 자동차대수_테스트(int inputCarCount, int carCountAnswer) {
        racingCar = new RacingCar(inputCarCount);
        int carsSize = racingCar.getCars().size();
        assertThat(carsSize).isEqualTo(carCountAnswer);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0보다 큰 값을 입력해주세요.",
            "-1, 0보다 큰 값을 입력해주세요.",
    })
    void 자동차대수_테스트_예외발생(int carCount, String errMessage) throws IllegalAccessException {
        assertThatThrownBy(() -> new RacingCar(carCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errMessage);
    }
}