package race.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {
    @Test
    void 우승자_찾기() {
        Winner winner = new Winner();
        List<Car> carList = Arrays.asList(new Car("pobi", 4),
                new Car("nana", 4),
                new Car("kai", 2)
        );

        List<String> winnerNames = winner.findWinner(carList);
        assertThat(winnerNames).containsExactly("pobi","nana");
    }

    @Test
    void 최댓값_찾기() {
        Winner winner = new Winner();
        List<Car> carList = Arrays.asList(new Car("pobi", 4),
                new Car("nana", 1),
                new Car("kai", 2)
        );

        assertThat(winner.findMax(carList)).isEqualTo(4);
    }
}
