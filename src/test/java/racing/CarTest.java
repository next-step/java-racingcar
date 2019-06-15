package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    void testCarName() {
        int carName = 1;
        Car car = new Car(carName);
        Assertions.assertThat(car.getName()).isEqualTo(String.valueOf(carName));
    }
}
