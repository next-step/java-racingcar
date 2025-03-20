import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void 자동차_전진() {
        Car car = new Car(0);
        car.go();
        assertThat(car.getLocation()).isEqualTo(1);
    }

    @Test
    void 자동차_4이상이면_전진() {
        Car car = new Car(0);
        car.randomGo(4);
        assertThat(car.getLocation()).isEqualTo(1);
    }

    @Test
    void 자동차_4미만이면_멈춤() {
        Car car = new Car(0);
        car.randomGo(1);
        assertThat(car.getLocation()).isEqualTo(0);
    }
}
