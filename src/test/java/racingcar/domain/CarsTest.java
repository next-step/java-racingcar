package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.strategy.RandomValueMovingStrategy;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4})
    @DisplayName("입력한 차 대수만큼 차 리스트를 생성한다.")
    void carListCreateTest_thenIsEqualTo(int carCount) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }

        assertThat(new Cars(carCount)).isEqualTo(new Cars(carList));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 100})
    @DisplayName("입력한 차 대수만큼의 차들이 이동한다.")
    void movingCarsTest_thenIsEqualTo(int carCount) {
        Cars cars = new Cars(carCount);
        cars.move(new RandomValueMovingStrategy());
        List<Car> values = cars.getValues();

        assertThat(cars).isEqualTo(new Cars(values));
    }
}
