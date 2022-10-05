package step4;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import step4.model.Car;

public class CarTest {

    @Test
    public void 전진테스트() {
        Car car = new Car("sonata", 0);
        assertThat(car.advanceCar(4)).isEqualTo(1);
    }

    @Test
    public void 전진하지않는테스트() {
        Car car = new Car("sonata", 0);
        assertThat(car.advanceCar(3)).isEqualTo(0);
    }

    @Test
    public void 현재위치_테스트() {
        Car car = new Car("sonata", 0);
        assertThat(car.currentLocation()).isEqualTo(0);
    }

    @Test
    public void 현재차이름_테스트() {
        Car car = new Car("sonata", 0);
        assertThat(car.currentName()).isEqualTo("sonata");
    }

}
