package racinggame.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RacingResultTest {

    private RacingResult result;

    @Test
    public void getMaximumPosition_when_there_are_one_maximum_value() {
        List<Car> cars = Arrays.asList(
                new Car("pobi", 7 ),
                new Car("crong", 10 ),
                new Car("honux", 13 )
        );
        result = new RacingResult(cars);

        int maximumPosition = result.getMaximumPosition();

        assertEquals( 13, maximumPosition );
    }

    @Test
    public void getMaximumPosition_when_there_are_two_maximum_values() {
        List<Car> cars = Arrays.asList(
                new Car("pobi", 7 ),
                new Car("crong", 10 ),
                new Car("honux", 10 )
        );
        result = new RacingResult(cars);

        int maximumPosition = result.getMaximumPosition();

        assertEquals( 10, maximumPosition );
    }

    @Test
    public void getWinnerList_when_there_are_one_maximum_value() {
        List<Car> cars = Arrays.asList(
                new Car("pobi", 7 ),
                new Car("crong", 10 ),
                new Car("honux", 13 )
        );
        result = new RacingResult(cars);

        List<Car> winners = result.getWinners();

        assertEquals( 1, winners.size() );
        assertEquals( 13, winners.get(0).getPosition() );
    }

    @Test
    public void getWinnerList_when_there_are_two_maximum_values() {
        List<Car> cars = Arrays.asList(
                new Car("pobi", 7 ),
                new Car("crong", 10 ),
                new Car("honux", 10 )
        );
        result = new RacingResult(cars);

        List<Car> winners = result.getWinners();

        assertEquals( 2, winners.size() );
        assertEquals( 10, winners.get(0).getPosition() );
        assertEquals( 10, winners.get(1).getPosition() );
    }

    @Test
    public void getWinnerList_when_there_are_all_maximum_values() {
        List<Car> cars = Arrays.asList(
                new Car("pobi", 10 ),
                new Car("crong", 10 ),
                new Car("honux", 10 )
        );
        result = new RacingResult(cars);

        List<Car> winners = result.getWinners();

        assertEquals( 3, winners.size() );
        assertEquals( 10, winners.get(0).getPosition() );
        assertEquals( 10, winners.get(1).getPosition() );
        assertEquals( 10, winners.get(2).getPosition() );
    }
}