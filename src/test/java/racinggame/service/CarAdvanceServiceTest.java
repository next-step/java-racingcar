package racinggame.service;

import org.junit.Before;
import org.junit.Test;
import racinggame.Car;
import racinggame.RandomMock;
import racinggame.service.CarAdvanceService;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CarAdvanceServiceTest {

    private CarAdvanceService processor;

    private RandomMock randomMock;

    @Before
    public void setUp() throws Exception {
        randomMock = new RandomMock();
        processor = new CarAdvanceService(randomMock);
    }

    @Test
    public void test_when_random_value_equals_or_is_greater_than_4() {

        int [] randomValues = new int [] { 4, 5, 6, 7, 8, 9 };
        int curPosition = 1;

        for( int randomValue : randomValues ) {
            randomMock.setDesignatedIntValue(randomValue);
            assertEquals(true, processor.isMovingForward());
            assertEquals( curPosition+1, processor.getNextPosition(curPosition) );
        }
    }

    @Test
    public void test_when_random_value_is_less_than_4() {

        int [] randomValues = new int [] { 0, 1, 2, 3 };
        int curPosition = 3;

        for( int randomValue : randomValues ) {
            randomMock.setDesignatedIntValue(randomValue);
            assertEquals(false, processor.isMovingForward());
            assertEquals( curPosition, processor.getNextPosition(curPosition) );
        }
    }

    @Test
    public void moveForward_succeeded() {

        List<Car> actualCars = Arrays.asList(
                new Car( "pobi", 1 ),
                new Car( "crong", 2 ),
                new Car( "honux", 3 )
        );

        List<Car> expectedCars = Arrays.asList(
                new Car( "pobi", 2 ),
                new Car( "crong", 3 ),
                new Car( "honux", 4 )
        );

        randomMock.setDesignatedIntValue(7);
        processor.moveForward(actualCars);

        for( int i = 0, size = actualCars.size(); i < size; ++i ) {
            assertEquals( expectedCars.get(i).getName(), actualCars.get(i).getName());
            assertEquals( expectedCars.get(i).getPosition(), actualCars.get(i).getPosition());
        }
    }

    @Test
    public void moveForward_failed() {

        List<Car> actualCars = Arrays.asList(
                new Car( "pobi", 1 ),
                new Car( "crong", 2 ),
                new Car( "honux", 3 )
        );

        List<Car> expectedCars = Arrays.asList(
                new Car( "pobi", 1 ),
                new Car( "crong", 2 ),
                new Car( "honux", 3 )
        );

        randomMock.setDesignatedIntValue(2);
        processor.moveForward(actualCars);

        for( int i = 0, size = actualCars.size(); i < size; ++i ) {
            assertEquals( expectedCars.get(i).getName(), actualCars.get(i).getName());
            assertEquals( expectedCars.get(i).getPosition(), actualCars.get(i).getPosition());
        }
    }
}