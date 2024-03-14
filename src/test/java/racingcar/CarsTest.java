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

    private static final String[] NAMES = {"pobi", "crong", "honux"};

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

    @Test
    @DisplayName("[성공] 자동차 경주의 최종 우승자가 한명인 경우 한명의 이름만 반환한다.")
    void 자동차_경주_우승자() {
        // Given
        Cars cars = new Cars(
                new Car(3, "pobi"),
                new Car(2, "crong"),
                new Car(1, "honux")
        );

        // When
        Winners winners = cars.getWinners();
        assertThat(winners.get().getNameStrings()).containsExactlyInAnyOrder("pobi");
    }

    @Test
    @DisplayName("[성공] 자동차 경주의 최종 우승자가 여러명인 경우 여러개의 이름을 반환한다.")
    void 자동차_경주_다수_우승자() {
        // Given
        Cars cars = new Cars(
                new Car(3, "pobi"),
                new Car(3, "crong"),
                new Car(1, "honux")
        );

        // When
        Winners winners = cars.getWinners();
        assertThat(winners.get().getNameStrings()).containsExactlyInAnyOrder("pobi", "crong");
    }

}
