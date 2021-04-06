package step3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {

    Racing racing = new Racing(2, 3);

    @Test
    void makeCar() {
        Car[] cars = racing.makeCar(2);
        assertThat(cars.length).isEqualTo(2);
    }

    @Test
    void movement() {
        Car car = new Car(2);
        racing.movement(car);
        assertThat(car.point).isGreaterThan(2);
    }

    @Test
    void random() {
        assertThat(racing.random()).isBetween(0, 10);
    }

}
