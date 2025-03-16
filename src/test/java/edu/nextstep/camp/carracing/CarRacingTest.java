package edu.nextstep.camp.carracing;

import org.junit.jupiter.api.Test;

import java.util.List;

import static edu.nextstep.camp.carracing.CarRacing.getMaxPosition;
import static edu.nextstep.camp.carracing.CarRacing.getMaxPositionCars;
import static org.assertj.core.api.Assertions.assertThat;

class CarRacingTest {

    @Test
    void 제일_많이_앞서나간_자동차의_포지션_출력_테스트() {
        // Given
        List<Car> cars = List.of(new Car("car1", 2), new Car("car2", 1), new Car("car3", 3));

        // When
        int maxPosition = getMaxPosition(cars);

        // Then
        assertThat(maxPosition).isEqualTo(3);
    }

    @Test
    void 우승_자동차_출력_테스트() {
        // Given
        List<Car> cars = List.of(
                new Car("car1", 2),
                new Car("car2", 1),
                new Car("car3", 3),
                new Car("sh", 3),
                new Car("baek", 3)
        );

        // When
        List<String> winners = getMaxPositionCars(cars, 3);

        // Then
        assertThat(winners.size()).isEqualTo(3);
        assertThat(winners).containsExactly("car3", "sh", "baek");
    }
}