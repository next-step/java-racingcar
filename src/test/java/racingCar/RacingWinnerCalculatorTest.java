package racingCar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingWinnerCalculatorTest {

    @Test
    void 우승자_한명일_때() {
        RacingWinnerCalculator winnerCalculator = new RacingWinnerCalculator(new RacingCars(List.of(
                new RacingCar("a", 3),
                new RacingCar("b", 4),
                new RacingCar("c", 5)
        )));

        assertThat(winnerCalculator.winners()).isEqualTo(List.of(new RacingCar("c", 5)));
    }

    @Test
    void 우승자_여러명일_때() {
        RacingWinnerCalculator winnerCalculator = new RacingWinnerCalculator(new RacingCars(List.of(
                new RacingCar("a", 4),
                new RacingCar("b", 3),
                new RacingCar("c", 4)
        )));

        assertThat(winnerCalculator.winners()).isEqualTo(List.of(
                new RacingCar("a", 4),
                new RacingCar("c", 4)
        ));
    }

    @Test
    void 경쟁자가_없을_때() {
        RacingWinnerCalculator winnerCalculator = new RacingWinnerCalculator(new RacingCars(List.of(
                new RacingCar("a", 3)
        )));

        assertThat(winnerCalculator.winners()).isEqualTo(List.of(
                new RacingCar("a", 3)
        ));
    }
}