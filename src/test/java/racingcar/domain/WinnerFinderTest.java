package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerFinderTest {

    @Test
    void 우승자_찾기() {
        Car a = new Car("a", new Position(10));
        Car b = new Car("b", new Position(12));
        Car c = new Car("c", new Position(13));

        List<Car> cars = Arrays.asList(a, b, c);

        WinnerFinder winnerFinder = new WinnerFinder(13);

        assertThat(winnerFinder.findWinners(cars)).containsExactly("c");
    }
}