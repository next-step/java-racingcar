package racing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.domain.Car;
import step3.domain.DecideMode;

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

    @Test
    void CarForWardTrueModeTest() {
        Car car = new Car();
        car.move(DecideMode.TRUE_RETURN_MODE);
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    void CarForWardFalseModeTest() {
        Car car = new Car();
        car.move(DecideMode.FALSE_RETURN_MODE);
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    void getNameTest() {
        String name = "java";
        Car car = new Car(name);
        assertThat(car.getName()).isEqualTo(name);
    }
}
