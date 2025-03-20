package racingcar.domain;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarWinnerCalculatorTest {

    @Test
    @DisplayName("정상적으로 우승자를 판단한다.")
    void determineWinners() {
        List<CarPosition> positions = Arrays.asList(
            new CarPosition("CarA", 5),
            new CarPosition("CarB", 3),
            new CarPosition("CarC", 4)
        );

        List<CarPositions> history = List.of(new CarPositions(positions));
        CarWinnerCalculator calculator = new CarWinnerCalculator(history);

        List<String> winners = calculator.determineWinners();
        assertThat(winners).containsExactly("CarA");
    }

    @Test
    @DisplayName("우승자가 2명일 때 정상적으로 우승자를 판단한다.")
    void determineWinners_2명() {
        List<CarPosition> positions = Arrays.asList(
            new CarPosition("CarA", 5),
            new CarPosition("CarB", 5),
            new CarPosition("CarC", 4)
        );

        List<CarPositions> history = List.of(new CarPositions(positions));
        CarWinnerCalculator calculator = new CarWinnerCalculator(history);

        List<String> winners = calculator.determineWinners();

        assertThat(winners).containsExactlyInAnyOrder("CarA", "CarB");
    }
}
