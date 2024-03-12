package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.mock.CustomCarMoveStrategy;
import racingcar.domain.Distance;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    @DisplayName("[성공] 자동차 3개를 가진 자동차 리스트를 생성한다.")
    void 자동차_리스트_생성_자동차3() {
        Cars cars = new Cars(3);
        assertThat(cars.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("[성공] 자동차 1개를 가진 자동차 리스트를 생성한다.")
    void 자동차_리스트_생성_자동차1() {
        Cars cars = new Cars(1);
        assertThat(cars.size()).isEqualTo(1);
    }

    @DisplayName("[성공] 자동차 3개를 가진 자동차 리스트의 자동차를 전진시킨다.")
    @ParameterizedTest(name = "{index} ==> Cars.get({0}) is 3.")
    @ValueSource(ints = {0, 1, 2})
    void 자동차_리스트_전진(int index) {
        // Given
        Cars cars = new Cars(3);

        // When
        // 모든 자동차 3회 전진
        int count = 3;
        while (count-- > 0) {
            cars.move(new CustomCarMoveStrategy("MOVE"));
        }

        // Then
        List<Car> actualCars = cars.get();
        assertThat(actualCars.get(index).getDistance()).isEqualTo(new Distance(3));
    }

}
