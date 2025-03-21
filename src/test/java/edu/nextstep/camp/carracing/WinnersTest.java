package edu.nextstep.camp.carracing;

import edu.nextstep.camp.carracing.domain.Car;
import edu.nextstep.camp.carracing.domain.Cars;
import edu.nextstep.camp.carracing.domain.Position;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {
    @Test
    void 우승자_출력_테스트() {
        // Given
        Car car1 = new Car("car1", new Position(2));
        Car car2 = new Car("car2", new Position(1));
        Car car3 = new Car("car3", new Position(3));
        Cars cars = new Cars(List.of(car1, car2, car3));

        // When
        Cars winners = cars.getWinners();

        // Then
        assertThat(winners.getWinnerNames()).containsExactly("car3");
    }

    @Test
    void 우승자_여러명_출력_테스트() {
        // Given
        Car car1 = new Car("car1", new Position(2));
        Car car2 = new Car("car2", new Position(1));
        Car car3 = new Car("car3", new Position(3));
        Car car4 = new Car("car4", new Position(3));
        Car car5 = new Car("car5", new Position(3));
        Cars cars = new Cars(List.of(car1, car2, car3, car4, car5));

        // When
        Cars winners = cars.getWinners();

        // Then
        assertThat(winners.getWinnerNames()).containsExactly("car3", "car4", "car5");
    }
}
