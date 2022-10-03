package step3;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    public void 전진하지않는테스트() {
        Car car = new Car(0);
        int location = car.advanceCar(1);
        System.out.println("!!!" + location);
        assertThat(location).isEqualTo(0);
    }

    @Test
    public void 전진하는테스트() {
        Car car = new Car(0);
        int location = car.advanceCar(4);
        assertThat(location).isEqualTo(1);
    }

    @Test
    public void 현재위치확인테스트() {
        Car car = new Car(10);
        int location = car.currentLocation();
        assertThat(location).isEqualTo(10);
    }
}
