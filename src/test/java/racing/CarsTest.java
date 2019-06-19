package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.domain.Cars;

public class CarsTest {
    private final static int CANT_MOVABLE_NUMBER = 3;
    private final static int CAN_MOVABLE_NUMBER = 4;
    private Cars cars;
    
    
    @BeforeEach
    void setUp() {
        cars = TestData.PLAYERS;
    }
    
    @Test
    void getCopiedCarTest() {
        Cars cars = TestData.PLAYERS;
        Cars copiedCar = cars.getCopiedCars();
        Assertions.assertThat(cars).isNotSameAs(copiedCar);
        Assertions.assertThat(cars.getCars()).isNotSameAs(copiedCar.getCars());
        Assertions.assertThat(cars.getCars().get(0)).isNotSameAs(copiedCar.getCars().get(0));
    }
    
    @Test
    void getCarNamesTest() {
        Assertions.assertThat(cars.getCarNames()).isEqualTo(TestData.DEFAULT_CAR_NAME);
    }
}
