package step3.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.model.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingServiceTest {

    @DisplayName("n대의 자동차가 생성된다")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    public void makeCars(int numberOfCars) {
        // given
        RacingService racingService = new RacingService();

        // when
        List<Car> cars = racingService.makeCars(numberOfCars);

        // then
        assertThat(cars.size()).isEqualTo(numberOfCars);
    }
}