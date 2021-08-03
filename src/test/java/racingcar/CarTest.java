package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Distance;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {
    private final Car car = new Car("test");

    @Test
    @DisplayName("move 하면 distance 가 1 증가")
    public void move() {
        Distance beforeDistance = car.getDistance();

        car.move();

        assertThat(car.getDistance()).isEqualTo(beforeDistance.increase());
    }
}