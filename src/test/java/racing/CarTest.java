package racing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.Car;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @ParameterizedTest
    @ValueSource(ints = {3, 100, 500, 11})
    void isRangeInTime(int time) {
        Car car = new Car();
        for(int i = 0; i<time ; i++) {
            car.move();
        }
        assertThat(car.getDistance()).isBetween(0, time);
    }
}
