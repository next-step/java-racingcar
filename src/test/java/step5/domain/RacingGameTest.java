package step5.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;

public class RacingGameTest {

    @Test
    public void maxLocationWithListTest() {
        List<Car> list = new ArrayList<Car>();
        list.add(new Car("abc", 3));
        list.add(new Car("ddd", 4));
        list.add(new Car("pobi", 5));
        RacingGame racingGame = new RacingGame(list);

        assertThat(racingGame.getMaxLocationWithList()).isEqualTo(5);
        assertThat(racingGame.getMaxLocationWithList()).isNotEqualTo(4);
    }

    public void winner() {
        List<Car> list = new ArrayList<Car>();
        list.add(new Car("abc", 3));
        list.add(new Car("ddd", 4));
        list.add(new Car("pobi", 5));
        RacingGame racingGame = new RacingGame(list);

        assertThat(racingGame.getWinner()).isEqualTo("pobi");
    }

    public void winner2() {
        List<Car> list = new ArrayList<Car>();
        list.add(new Car("abc", 3));
        list.add(new Car("ddd", 5));
        list.add(new Car("pobi", 5));
        RacingGame racingGame = new RacingGame(list);

        assertThat(racingGame.getWinner()).contains("pobi", "ddd");
    }
}
