package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {
    private final static int ONE_MOVED_POSITION = 1;
    private final static int TEST_CAR_NAME = 1;
    private Car car;
    
    @BeforeEach
    void setUp() {
        car = new Car(TEST_CAR_NAME);
    }
    
    @Test
    void constructorTest() {
        Assertions.assertThat(car.getName()).isEqualTo(String.valueOf(TEST_CAR_NAME));
        Assertions.assertThat(car.getPosition()).isEqualTo(Car.DEFAULT_POSITION);
    }
    
    @Test
    void forwardTest() {
        car.forward();
        Assertions.assertThat(car.getPosition()).isEqualTo(ONE_MOVED_POSITION);
    }
}
