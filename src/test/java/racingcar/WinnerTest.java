package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Winner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {

    @Test
    void winnerTest() {
        List<Car> cars = Arrays.asList(
                new Car("test1"), new Car("test2")
                , new Car("test3"), new Car("test4"));

        cars.get(0).move(() -> true);

        Winner winner = new Winner(cars);

        assertThat(winner.getWinner()).containsExactlyInAnyOrder("test1");
    }
}
