package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.*;
import racingcar.mock.AlwaysMoveStrategy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    private final static Names NAMES = new Names(new NameSeparator("pobi,crong,honux"));

    @Test
    @DisplayName("[성공] 자동차 3개를 가진 자동차 리스트를 생성한다.")
    void 자동차_리스트_생성_자동차3() {
        Cars cars = new Cars(NAMES);
        assertThat(cars.size()).isEqualTo(3);
    }

    @DisplayName("[성공] 자동차 3개를 가진 자동차 리스트의 자동차를 모두 3번씩 전진시킨다.")
    @ParameterizedTest(name = "[{index}] Cars.get({0}) is 3.")
    @ValueSource(ints = {0, 1, 2})
    void 자동차_리스트_전진(int index) {
        // Given
        Cars cars = new Cars(NAMES);

        // When
        // 모든 자동차 3회 전진
        int count = 3;
        while (count-- > 0) {
            cars.move(new AlwaysMoveStrategy());
        }

        // Then
        List<Car> actualCars = cars.get();
        assertThat(actualCars.get(index).getDistance()).isEqualTo(new Distance(3));
    }

}
