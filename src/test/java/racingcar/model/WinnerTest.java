package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class WinnerTest {

    @Test
    void 우승자_찾기() {
        List<Car> cars = Arrays.asList(
            new Car("leah", 5),
            new Car("sam", 6),
            new Car("jiin", 4)
        );
        Winner winner = new Winner(cars);

        List<String> winners = winner.findWinner();

        assertThat(winners).containsExactly("sam");
    }


}
