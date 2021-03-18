package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Winner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {

    @DisplayName("우승자 여려명 비교")
    @Test
    void winnersTest() {
        List<Car> cars = Arrays.asList(
                new Car("test1"), new Car("test2")
                , new Car("test3"), new Car("test4"));

        cars.get(0).move(() -> true);
        cars.get(1).move(() -> true);
        Winner winners = new Winner(cars);

        assertThat(winners.getWinner()).containsExactlyInAnyOrder(new String[]{"test1", "test2"});
    }

    @DisplayName("우승자 비교")
    @Test
    void winnerTest() {
        List<Car> cars = Arrays.asList(
                new Car("test1"), new Car("test2")
                , new Car("test3"), new Car("test4"));

        cars.get(0).move(() -> true);
        Winner winners = new Winner(cars);

        assertThat(winners.getWinner()).containsExactlyInAnyOrder("test1");
    }
}
