package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarsTest {

    @DisplayName("이름의 수만큼 자동차를 만든다")
    @Test
    void createsCars() {
        Cars cars = new Cars(List.of("pobi", "crong", "honux"));

        assertThat(cars.getCars())
                .extracting(Car::getName)
                .containsExactly("pobi", "crong", "honux");
    }

    @DisplayName("한 번의 이동에서 자동차마다 각자의 값으로 움직인다")
    @Test
    void movesEachCarWithItsOwnNumber() {
        Cars cars = new Cars(List.of("pobi", "crong"));
        Iterator<Integer> numbers = List.of(4, 3).iterator();

        cars.moveAll(numbers::next);

        assertThat(cars.getCars())
                .extracting(Car::getPosition)
                .containsExactly(1, 0);
    }

    @DisplayName("가장 멀리 간 자동차가 우승한다")
    @Test
    void winner() {
        Cars cars = new Cars(List.of("pobi", "crong", "honux"));
        Iterator<Integer> numbers = List.of(3, 4, 3).iterator();

        cars.moveAll(numbers::next);

        assertThat(cars.winners()).containsExactly("crong");
    }

    @DisplayName("가장 멀리 간 자동차가 여럿이면 모두 우승한다")
    @Test
    void winners() {
        Cars cars = new Cars(List.of("pobi", "crong", "honux"));
        Iterator<Integer> numbers = List.of(4, 3, 4).iterator();

        cars.moveAll(numbers::next);

        assertThat(cars.winners()).containsExactly("pobi", "honux");
    }
}
