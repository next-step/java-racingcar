package racingCar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {


    @Test
    void 이동(){
        Car car = new Car(3);
        car.move(4);
        assertThat(car.checkPosition(4)).isTrue();
    }

    @Test
    void 정지(){
        Car car = new Car(3);
        car.move(3);
        assertThat(car.checkPosition(3)).isTrue();
    }
}
