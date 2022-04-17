package racing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void 거리_덧셈() {
        Car car = new Car();
        int prevDistance = car.getDistance();
        int addDistance = 3;

        car.addDistance(addDistance);

        assertThat(prevDistance+addDistance).isEqualTo(car.getDistance());
    }

}