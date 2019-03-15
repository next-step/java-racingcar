package racingcar;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RoundTest {
    @Test
    public void 라운드의_승자를_찾기() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("aaa", 4));
        cars.add(new Car("bbb", 3));
        cars.add(new Car("ccc", 2));

        Round round = new Round(cars);

        assertThat(round.getWinnerId()).isEqualTo("aaa");
    }

    @Test
    public void 라운드의_승자를_찾기_두명일_경우() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("aaa", 4));
        cars.add(new Car("bbb", 4));
        cars.add(new Car("ccc", 2));

        Round round = new Round(cars);

        assertThat(round.getWinnerId()).isEqualTo("aaa, bbb");
    }
}