package racinggame.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameResultTest {

    private static List<Car> cars;

    @Before
    public void setUp() {
        cars = Arrays.asList(
                new Car("owner", 1),
                new Car("chris", 3),
                new Car("mary", 2),
                new Car("john", 3));
    }

    @Test
    public void 레이싱_경기_우승자_구하기() {

        RacingGameResult racingGameResult = new RacingGameResult(cars);

        List<String> winners = racingGameResult.getWinner();

        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners).contains("chris", "john");
    }

}