package racinggame.service;

import org.junit.Test;
import racinggame.domain.Car;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CarAdvanceServiceTest {

    private CarAdvanceService carAdvanceService;

    @Test
    public void test_when_random_value_equals_or_is_greater_than_4() {

        int [] randomValues = new int [] { 4, 5, 6, 7, 8, 9 };

        Car car = new Car( "crong", 1 );
        int expectedPosition = 2;

        for( int randomValue : randomValues ) {
            carAdvanceService = new CarAdvanceService(() -> randomValue);

            assertEquals(true, carAdvanceService.isMovingForward());
            carAdvanceService.moveForward(car);
            assertEquals( expectedPosition++, car.getPosition() );
        }
    }

    @Test
    public void test_when_random_value_is_less_than_4() {

        int [] randomValues = new int [] { 0, 1, 2, 3 };

        Car car = new Car( "crong", 1 );
        int expectedPosition = 1;

        for( int randomValue : randomValues ) {
            carAdvanceService = new CarAdvanceService(() -> randomValue);

            assertEquals(false, carAdvanceService.isMovingForward());
            carAdvanceService.moveForward(car);
            assertEquals( expectedPosition, car.getPosition() );
        }

    }

    @Test
    public void moveForward_succeeded() {
        List<Car> expected = Arrays.asList(
            new Car( "pobi", 2 ),
            new Car( "crong", 3 ),
            new Car( "honux", 4 )
        );

        List<Car> actual = Arrays.asList(
            new Car( "pobi", 1 ),
            new Car( "crong", 2 ),
            new Car( "honux", 3 )
        );

        carAdvanceService = new CarAdvanceService(() -> 4);
        carAdvanceService.moveForward(actual);

        assertEquals( expected, actual );
    }

    @Test
    public void moveForward_failed() {

        List<Car> actual = Arrays.asList(
                new Car( "pobi", 1 ),
                new Car( "crong", 2 ),
                new Car( "honux", 3 )
        );

        List<Car> expected = Arrays.asList(
                new Car( "pobi", 1 ),
                new Car( "crong", 2 ),
                new Car( "honux", 3 )
        );

        carAdvanceService = new CarAdvanceService(() -> 3);
        carAdvanceService.moveForward(actual);

        assertEquals( expected, actual );
    }
}