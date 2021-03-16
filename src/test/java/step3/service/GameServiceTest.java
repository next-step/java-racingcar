package step3.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.domain.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameServiceTest {

    @DisplayName("n대의 자동차가 생성된다")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    public void makeCars(int countOfCars) {
        // given
        GameService gameService = GameService.newInstance();

        // when
        List<Car> cars = gameService.makeCars(countOfCars);

        // then
        assertThat(cars.size()).isEqualTo(countOfCars);
    }
}
