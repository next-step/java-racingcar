package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @DisplayName("모든 자동차들이 전진")
    @Test
    void 전진_테스트() {
        Cars cars = new Cars(List.of(new Car("pobi", 0), new Car("crong", 0)));
        cars.move(() -> 1);

        assertThat(cars.getCars().stream()
            .map(Car::getDistance)).containsExactly(1, 1);
    }

    @DisplayName("모든 자동차 제자리")
    @Test
    void 제자리_테스트() {
        Cars cars = new Cars(List.of(new Car("pobi", 0), new Car("crong", 0)));
        cars.move(() -> 0);

        assertThat(cars.getCars().stream()
            .map(Car::getDistance)).containsExactly(0, 0);
    }

    @DisplayName("최종 우승자가 여러명 일떄")
    @Test
    void 최종_우승자가_여러명일떄() {
        Cars cars = new Cars(List.of(new Car("pobi", 0), new Car("crong", 0)));
        cars.move(() -> 1);

        assertThat(cars.findWinners()).isEqualTo("pobi, crong");
    }

    @DisplayName("최종 우승자가 한명일때")
    @Test
    void 최종_우승자가_한명일떄() {
        Cars cars = new Cars(List.of(new Car("pobi", 1), new Car("crong", 0)));
        cars.move(() -> 1);

        assertThat(cars.findWinners()).isEqualTo("pobi");
    }

}