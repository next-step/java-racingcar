package racinggame.winner;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("가장 멀리간 자동차 리스트를 반환한다.")
    void 가장_멀리간_자동차() {
        Cars sut = new Cars(
            List.of(
                new Car("car1", 1),
                new Car("car2", 2),
                new Car("car3", 1)
            )
        );

        assertThat(sut.getFarthestCars()).hasSize(1);
    }

    @Test
    @DisplayName("모든 자동차가 한번씩 이동을 시도한다")
    void 자동차들_이동시도() {
        Cars sut = new Cars(
            List.of(
                new Car("car1"),
                new Car("car2"),
                new Car("car3")
            )
        );

        Iterator<Integer> numbers = List.of(3, 4, 5).iterator();
        sut.move(numbers::next);

        assertThat(sut.getCars())
            .extracting(Car::getPosition)
            .containsExactly(1, 2, 2);
    }
}