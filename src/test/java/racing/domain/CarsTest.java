package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @DisplayName("모든 자동차들이 전진")
    @Test
    void 전진_테스트() {
        Cars cars = new Cars(List.of(new Car(), new Car()));
        MovableStrategy movableStrategy = () -> 9;

        cars.move(movableStrategy);

        assertThat(cars.getCars().stream().map(Car::getMoved)).containsExactly("-", "-");
    }

    @DisplayName("모든 자동차 제자리")
    @Test
    void 제자리_테스트() {
        Cars cars = new Cars(List.of(new Car(), new Car()));
        MovableStrategy movableStrategy = () -> 1;

        cars.move(movableStrategy);

        assertThat(cars.getCars().stream().map(Car::getMoved)).containsExactly("", "");
    }

}