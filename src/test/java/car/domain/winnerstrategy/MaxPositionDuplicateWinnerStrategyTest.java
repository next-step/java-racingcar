package car.domain.winnerstrategy;

import static org.assertj.core.api.Assertions.assertThat;

import car.domain.Car;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MaxPositionDuplicateWinnerStrategyTest {

    @Test
    @DisplayName("position 값이 가장 큰 자동차를 우승자로 선출한다.")
    void test1() {
        List<Car> cars = List.of(
            new Car(3, "a"),
            new Car(5, "b"),
            new Car(5, "c")
        );

        WinnerStrategy winnerStrategy = new MaxPositionDuplicateWinnerStrategy();
        List<Car> winners = winnerStrategy.getWinners(cars);
        List<String> winnerNames = winners.stream()
            .map(Car::getNameValue)
            .collect(Collectors.toList());

        assertThat(winners.size()).isEqualTo(2);
        assertThat(winnerNames).containsExactly("b", "c");
    }
}
