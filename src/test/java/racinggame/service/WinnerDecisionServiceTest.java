package racinggame.service;

import org.junit.Before;
import org.junit.Test;
import racinggame.domain.Car;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class WinnerDecisionServiceTest {

    @Test
    public void getMaximumPosition_when_there_are_one_maximum_value() {
        List<Car> cars = Arrays.asList(
            new Car("pobi", 7 ),
            new Car("crong", 10 ),
            new Car("honux", 13 )
        );

        int result = WinnerDecisionService.getMaximumPosition(cars);

        assertEquals( 13, result );
    }

    @Test
    public void getMaximumPosition_when_there_are_two_maximum_values() {
        List<Car> cars = Arrays.asList(
            new Car("pobi", 7 ),
            new Car("crong", 10 ),
            new Car("honux", 10 )
        );

        int result = WinnerDecisionService.getMaximumPosition(cars);

        assertEquals( 10, result );
    }

    @Test
    public void getWinnerList_when_there_are_one_maximum_value() {
        List<Car> cars = Arrays.asList(
                new Car("pobi", 7 ),
                new Car("crong", 10 ),
                new Car("honux", 13 )
        );

        List<Car> winnerList = WinnerDecisionService.getWinnerList(cars);

        assertEquals( 1, winnerList.size() );
        assertEquals( 13, winnerList.get(0).getPosition() );
    }

    @Test
    public void getWinnerList_when_there_are_two_maximum_values() {
        List<Car> cars = Arrays.asList(
                new Car("pobi", 7 ),
                new Car("crong", 10 ),
                new Car("honux", 10 )
        );

        List<Car> winnerList = WinnerDecisionService.getWinnerList(cars);

        assertEquals( 2, winnerList.size() );
        assertEquals( 10, winnerList.get(0).getPosition() );
        assertEquals( 10, winnerList.get(1).getPosition() );
    }

    @Test
    public void getWinnerList_when_there_are_all_maximum_values() {
        List<Car> cars = Arrays.asList(
                new Car("pobi", 10 ),
                new Car("crong", 10 ),
                new Car("honux", 10 )
        );

        List<Car> winnerList = WinnerDecisionService.getWinnerList(cars);

        assertEquals( 3, winnerList.size() );
        assertEquals( 10, winnerList.get(0).getPosition() );
        assertEquals( 10, winnerList.get(1).getPosition() );
        assertEquals( 10, winnerList.get(2).getPosition() );
    }
}