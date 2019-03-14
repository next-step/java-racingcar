package racinggame.service;

import org.junit.Test;
import racinggame.domain.Car;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CarAdvanceServiceTest {

    private CarAdvanceService carAdvanceService;

    private MockRandomValueGeneratorImpl mockRandomValueGeneratorImpl;

    @Test
    public void test_when_random_value_equals_or_is_greater_than_4() {

        int [] randomValues = new int [] { 4, 5, 6, 7, 8, 9 };

        Car car = new Car( "crong", 1 );
        int expectedPosition = 2;

        for( int randomValue : randomValues ) {
            mockRandomValueGeneratorImpl = new MockRandomValueGeneratorImpl(randomValue);
            carAdvanceService = new CarAdvanceService(mockRandomValueGeneratorImpl);

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
            mockRandomValueGeneratorImpl = new MockRandomValueGeneratorImpl(randomValue);
            carAdvanceService = new CarAdvanceService(mockRandomValueGeneratorImpl);

            assertEquals(false, carAdvanceService.isMovingForward());
            carAdvanceService.moveForward(car);
            assertEquals( expectedPosition, car.getPosition() );
        }

    }

    @Test
    public void moveForward_succeeded() {

        List<Car> actualCarList = Arrays.asList(
            new Car( "pobi", 1 ),
            new Car( "crong", 2 ),
            new Car( "honux", 3 )
        );

        List<Car> expectedCarList = Arrays.asList(
            new Car( "pobi", 2 ),
            new Car( "crong", 3 ),
            new Car( "honux", 4 )
        );

        mockRandomValueGeneratorImpl = new MockRandomValueGeneratorImpl(7);
        carAdvanceService = new CarAdvanceService(mockRandomValueGeneratorImpl);
        carAdvanceService.moveForward(actualCarList);

        for( int i = 0, size = actualCarList.size(); i < size; ++i ) {
            assertEquals( expectedCarList.get(i).getName(), actualCarList.get(i).getName() );
            assertEquals( expectedCarList.get(i).getPosition(), actualCarList.get(i).getPosition() );
        }
    }

    @Test
    public void moveForward_failed() {

        List<Car> actualCarList = Arrays.asList(
                new Car( "pobi", 1 ),
                new Car( "crong", 2 ),
                new Car( "honux", 3 )
        );

        List<Car> expectedCarList = Arrays.asList(
                new Car( "pobi", 1 ),
                new Car( "crong", 2 ),
                new Car( "honux", 3 )
        );

        mockRandomValueGeneratorImpl = new MockRandomValueGeneratorImpl(2);
        carAdvanceService = new CarAdvanceService(mockRandomValueGeneratorImpl);
        carAdvanceService.moveForward(actualCarList);

        for( int i = 0, size = actualCarList.size(); i < size; ++i ) {
            assertEquals( expectedCarList.get(i).getName(), actualCarList.get(i).getName() );
            assertEquals( expectedCarList.get(i).getPosition(), actualCarList.get(i).getPosition() );
        }
    }
}