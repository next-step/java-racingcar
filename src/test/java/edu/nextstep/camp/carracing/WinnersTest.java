package edu.nextstep.camp.carracing;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {
    @Test
    void 우승자_출력_테스트() {
        // Given
        Car car1 = new Car("car1", 2);
        Car car2 = new Car("car2", 1);
        Car car3 = new Car("car3", 3);

        // When
        List<String> winners = Winners.getWinners(List.of(car1, car2, car3));

        // Then
        assertThat(winners).containsExactly("car3");
    }

    @Test
    void 우승자_여러명_출력_테스트() {
        // Given
        Car car1 = new Car("car1", 2);
        Car car2 = new Car("car2", 1);
        Car car3 = new Car("car3", 3);
        Car car4 = new Car("car4", 3);
        Car car5 = new Car("car5", 3);

        // When
        List<String> winners = Winners.getWinners(List.of(car1, car2, car3, car4, car5));

        // Then
        assertThat(winners).containsExactly("car3", "car4", "car5");
    }
}
