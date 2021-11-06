package car_racing;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void showCurrStatus() {
        Car car = new Car();
        car.move();

        String currStatus = car.getCurrStatus();
        assertThat(currStatus).isIn(Lists.list("", "-"));
    }
}
