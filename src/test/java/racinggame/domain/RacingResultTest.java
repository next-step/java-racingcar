package racinggame.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class RacingResultTest {

    private RacingResult result;

    @Test
    public void getMaximumPosition_when_there_is_one_maximum_value() {
        int expected = 13;
        List<Car> cars = Arrays.asList(
                new Car("pobi", 7 ),
                new Car("crong", 10 ),
                new Car("honux", expected )
        );
        result = new RacingResult(cars);

        int actual = result.getMaximumPosition();

        assertEquals( expected, actual );
    }

    @Test
    public void getMaximumPosition_when_there_are_two_maximum_values() {
        int expected = 10;
        List<Car> cars = Arrays.asList(
                new Car("pobi", 7 ),
                new Car("crong", expected ),
                new Car("honux", expected )
        );
        result = new RacingResult(cars);

        int actual = result.getMaximumPosition();

        assertEquals( expected, actual );
    }

    @Test
    public void getWinners_when_there_is_one_maximum_value() {
        int expected = 13;
        List<Car> cars = Arrays.asList(
                new Car("pobi", 7 ),
                new Car("crong", 10 ),
                new Car("honux", expected )
        );
        result = new RacingResult(cars);

        List<Car> winners = result.getWinners();

        assertEquals( 1, winners.size() );
        assertEquals( expected, winners.get(0).getPosition() );
    }

    @Test
    public void getWinners_when_there_are_two_maximum_values() {
        int expected = 10;
        List<Car> cars = Arrays.asList(
                new Car("pobi", 7 ),
                new Car("crong", expected ),
                new Car("honux", expected )
        );
        result = new RacingResult(cars);

        List<Car> winners = result.getWinners();

        assertEquals( 2, winners.size() );
        assertEquals( expected, winners.get(0).getPosition() );
        assertEquals( expected, winners.get(1).getPosition() );
    }

    @Test
    public void getWinners_when_there_are_all_maximum_values() {
        int expected = 10;
        List<Car> cars = Arrays.asList(
                new Car("pobi", expected ),
                new Car("crong", expected ),
                new Car("honux", expected )
        );
        result = new RacingResult(cars);

        List<Car> winners = result.getWinners();

        assertEquals( 3, winners.size() );
        assertEquals( expected, winners.get(0).getPosition() );
        assertEquals( expected, winners.get(1).getPosition() );
        assertEquals( expected, winners.get(2).getPosition() );
    }

    @Test
    public void getWinnerNames_for_a_winner() {
        List<Car> winners = Arrays.asList(
                new Car("pororo")
        );

        List<String> expected = winners.stream().map(Car::getName).collect(Collectors.toList());
        List<String> actual = RacingResult.getWinnerNames(winners);

        assertEquals(expected, actual);
    }

    @Test
    public void getWinnerNames_for_two_winners() {
        List<Car> winners = Arrays.asList(
                new Car("pororo"),
                new Car("pobi")
        );

        List<String> expected = winners.stream().map(Car::getName).collect(Collectors.toList());
        List<String> actual = RacingResult.getWinnerNames(winners);

        assertEquals(expected, actual);
    }
}