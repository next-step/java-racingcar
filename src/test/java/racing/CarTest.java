package racing;

import org.junit.Test;

import java.util.Iterator;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    public void 이동테스트() {
        Car car = new Car("jypweback");
        car.move();
        car.move();
        car.move();

        assertThat(car.getMovePosition()).isEqualTo(3);
    }
}