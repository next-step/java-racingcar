package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.strategy.RandomValueStrategy;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4})
    @DisplayName("입력한 차 대수만큼 차 리스트를 생성을 확인하는 테스트")
    void carListCreateTest_thenIsEqualTo(int carCount) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }
        assertThat(new Cars(carCount)).isEqualTo(new Cars(carList));
    }

    @ParameterizedTest
    @CsvSource(value = {"3:5", "10:1000", "123:678910", "0:0"}, delimiter = ':')
    @DisplayName("입력한 차 대수와, 입력한 움직임 횟수를 통해 자동차 경주가 잘 실행되는지 테스트")
    void carRacingGameTest_thenIsEqualTo(int carCount, int tryCount) {
        Cars cars = new Cars(carCount);
        List<Car> values = cars.racing(tryCount, new RandomValueStrategy());
        assertThat(cars).isEqualTo(new Cars(values));
    }
}