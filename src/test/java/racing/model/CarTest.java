package racing.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    void 포지션비교() {
        Car car1 = new Car("car");
        car1.move(5);
        Car car2 = new Car("car");
        car2.move(6);
        assertThat(car1).isEqualTo(car2);
        Car car3 = new Car("car");
        car2.move(4);
        assertThat(car1).isNotEqualTo(car3);
    }
}