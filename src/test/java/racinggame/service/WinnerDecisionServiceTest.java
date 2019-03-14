package racinggame.service;

import org.junit.Before;
import org.junit.Test;
import racinggame.domain.Car;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class WinnerDecisionServiceTest {

    private WinnerDecisionService winnerDecisionService;

    @Before
    public void setUp() throws Exception {
        winnerDecisionService = new WinnerDecisionService();
    }

    @Test
    public void getMaximumPosition_when_there_are_one_maximum_value() {
        List<Car> carList = Arrays.asList(
            new Car("pobi", 7 ),
            new Car("crong", 10 ),
            new Car("honux", 13 )
        );

        int result = winnerDecisionService.getMaximumPosition(carList);

        assertEquals( 13, result );
    }

    @Test
    public void getMaximumPosition_when_there_are_two_maximum_values() {
        List<Car> carList = Arrays.asList(
            new Car("pobi", 7 ),
            new Car("crong", 10 ),
            new Car("honux", 10 )
        );

        int result = winnerDecisionService.getMaximumPosition(carList);

        assertEquals( 10, result );
    }

    @Test
    public void getWinnerList_when_there_are_one_maximum_value() {
        List<Car> carList = Arrays.asList(
                new Car("pobi", 7 ),
                new Car("crong", 10 ),
                new Car("honux", 13 )
        );

        List<Car> winnerList = winnerDecisionService.getWinnerList(carList);

        assertEquals( 1, winnerList.size() );
        assertEquals( 13, winnerList.get(0).getPosition() );
    }

    @Test
    public void getWinnerList_when_there_are_two_maximum_values() {
        List<Car> carList = Arrays.asList(
                new Car("pobi", 7 ),
                new Car("crong", 10 ),
                new Car("honux", 10 )
        );

        List<Car> winnerList = winnerDecisionService.getWinnerList(carList);

        assertEquals( 2, winnerList.size() );
        assertEquals( 10, winnerList.get(0).getPosition() );
        assertEquals( 10, winnerList.get(1).getPosition() );
    }

    @Test
    public void getWinnerList_when_there_are_all_maximum_values() {
        List<Car> carList = Arrays.asList(
                new Car("pobi", 10 ),
                new Car("crong", 10 ),
                new Car("honux", 10 )
        );

        List<Car> winnerList = winnerDecisionService.getWinnerList(carList);

        assertEquals( 3, winnerList.size() );
        assertEquals( 10, winnerList.get(0).getPosition() );
        assertEquals( 10, winnerList.get(1).getPosition() );
        assertEquals( 10, winnerList.get(2).getPosition() );
    }
}