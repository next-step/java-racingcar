package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class WinnerTest {
    @Test
    void 가장_많이_전진한_자동차가_우승한다() {
        List<Car> cars = Arrays.asList(
            new Car("jack", 7),
            new Car("smith", 6),
            new Car("lana", 4)
        );
        Winner winner = new Winner(cars);
        winner.setWinners();
        List<Car> winners = winner.getWinners();
        assertThat(winners.get(0)).isEqualTo(cars.get(0));
    }
}
