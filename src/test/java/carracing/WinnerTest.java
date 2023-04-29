package carracing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 1. 위치가 가장 큰 우승자를 반환한다.
 */
class WinnerTest {
    private List<Car> cars;

    @BeforeEach
    void init() {
        cars = List.of(new Car(new Name("pobi"), new Position(4)),
                new Car(new Name("conan"), new Position(2)),
                new Car(new Name("honux"), new Position(3))
        );

    }

    @DisplayName("위치가 가장 큰 우승자를 반환한다.")
    @Test
    void findWinner() {
        Winner winners = new Winner(cars);
        List<String> result = winners.addWinners().stream()
                .map(Car::getName)
                .collect(Collectors.toList());
        assertThat(result).contains("pobi");
    }


}