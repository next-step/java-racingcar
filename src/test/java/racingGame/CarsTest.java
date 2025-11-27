package racingGame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("fromNames로 생성하면 각 이름에 해당하는 Car들을 가진다")
    void fromNames_createsCars() {
        List<String> names = Arrays.asList("a", "b", "c");

        Cars cars = Cars.fromNames(names);

        assertThat(cars.asList())
            .hasSize(3)
            .extracting(Car::name)
            .containsExactly("a", "b", "c");
    }

    @Test
    @DisplayName("moveAll을 호출하면 모든 Car에 전략이 적용되어 이동한다")
    void moveAll_movesAllCars() {
        List<String> names = Arrays.asList("a", "b");
        Cars cars = Cars.fromNames(names);

        cars.moveAll(() -> true);

        assertThat(cars.asList())
            .extracting(Car::position)
            .containsExactly(1, 1);
    }

    @Test
    @DisplayName("winnerNames는 최대 위치를 가진 Car의 이름들만 반환한다")
    void winnerNames_returnsNamesWithMaxPosition() {
        List<String> names = Arrays.asList("a", "b", "c");
        Cars cars = Cars.fromNames(names);

        // a : 2칸, b : 1칸, c : 2칸
        cars.asList().get(0).move(() -> true);
        cars.asList().get(0).move(() -> true);

        cars.asList().get(1).move(() -> true);

        cars.asList().get(2).move(() -> true);
        cars.asList().get(2).move(() -> true);

        List<String> winners = cars.winnerNames();

        assertThat(winners).containsExactlyInAnyOrder("a", "c");
    }

    @Test
    @DisplayName("asList는 수정 불가능한 리스트를 반환해야 한다")
    void asList_isUnmodifiable() {
        Cars cars = Cars.fromNames(Arrays.asList("a", "b"));

        List<Car> exposed = cars.asList();

        boolean thrown = false;
        try {
            exposed.add(new Car("c"));
        } catch (UnsupportedOperationException e) {
            thrown = true;
        }

        assertThat(thrown).isTrue();
    }
}
