package racingcar;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RoundTest {
    @Test
    public void 라운드의_승자를_찾기() {
        List<Car> cars = Arrays.asList(
                new Car("aaa", 4),
                new Car("bbb", 3),
                new Car("ccc", 3)
        );

        Round round = new Round(cars);

        assertThat(round.getWinners().getWinnersName()).isEqualTo("aaa");
    }

    @Test
    public void 라운드의_승자를_찾기_두명일_경우() {
        List<Car> cars = Arrays.asList(
                new Car("aaa", 4),
                new Car("bbb", 4),
                new Car("ccc", 3)
        );
        Round round = new Round(cars);

        assertThat(round.getWinners().getWinnersName()).isEqualTo("aaa, bbb");
    }
}