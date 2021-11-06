package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarFactoryTest {

    @DisplayName("입력한 자동차 개수에 맞는 RacingCars 반환")
    @ParameterizedTest
    @ValueSource(ints = {3, 2, 6, 4, 7})
    void createRacingCars(int numberOfCars) {
        RacingCars racingCars = CarFactory.createRacingCars(numberOfCars);
        assertThat(racingCars.numberOfCars()).isEqualTo(numberOfCars);
    }

}