package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {
    private final static int ONE_MOVED_POSITION = 1;
    private int carName;
    private Car car;
    
    @BeforeEach
    void setUp() {
        carName = 1;
        car = new Car(carName);
    }
    
    @Test
    void constructorTest() {
        Assertions.assertThat(car.getName()).isEqualTo(String.valueOf(carName));
        Assertions.assertThat(car.getPosition()).isEqualTo(Car.DEFAULT_POSITION);
    }
    
    @Test
    void forwardTest() {
        car.forward();
        Assertions.assertThat(car.getPosition()).isEqualTo(ONE_MOVED_POSITION);
    }
}
