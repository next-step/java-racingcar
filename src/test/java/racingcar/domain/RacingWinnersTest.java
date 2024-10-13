package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingWinnersTest {


    @Test
    void 우승자_1인() {
        Car a = new Car("a", new Position(10));
        Car b = new Car("b", new Position(12));
        Car c = new Car("c", new Position(13));

        List<Car> cars = Arrays.asList(a, b, c);

        RacingWinners racingWinner = new RacingWinners(cars, 13);

        assertThat(racingWinner).isEqualTo(new RacingWinners(Arrays.asList("c")));
    }

    @Test
    void 우승자_2인() {
        Car a = new Car("a", new Position(10));
        Car b = new Car("b", new Position(12));
        Car c = new Car("c", new Position(12));

        List<Car> cars = Arrays.asList(a, b, c);

        RacingWinners racingWinner = new RacingWinners(cars, 12);

        assertThat(racingWinner).isEqualTo(new RacingWinners(Arrays.asList("b","c")));

    }

}