package study.racing.model.car;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RacingCarsTest {

    @DisplayName("생성자에 정수가 주어졌을 때 해당 숫자만큼 car가 생성되는지 검증")
    @ParameterizedTest
    @CsvSource({ "1, 1", "100, 100" })
    void createRacingCarsTest(int carCount, int expected) {
        RacingCars racingCars = new RacingCars(carCount);

        assertThat(racingCars.result().size()).isEqualTo(expected);
    }
}
