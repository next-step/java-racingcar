package race.domain;

import org.junit.jupiter.api.Test;
import race.constant.Definition;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {
    @Test
    void 우승자_찾기() {
        Winner winner = new Winner();
        List<Car> carList = Arrays.asList(Definition.A, Definition.B, Definition.C);
        List<String> winnerNames = winner.findWinner(carList);
        assertThat(winnerNames).containsExactlyInAnyOrder("a","b");
    }

    @Test
    void 최댓값_찾기() {
        Winner winner = new Winner();
        List<Car> carList = List.of(Definition.A, Definition.D, Definition.C);

        assertThat(winner.findMax(carList)).isEqualTo(4);
    }
}
