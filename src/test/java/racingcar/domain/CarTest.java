package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    Car car;

    @BeforeEach
    public void setUp() {
        car = new Car();
    }

    @Test
    @DisplayName("Car의 이동거리(distance)를 증가 시킨다.")
    public void should_increase_car_distance_when_random_number_is_4_or_more() {
        assertThat(car.move(4)).isEqualTo(1);
    }

    @Test
    @DisplayName("Car의 이동거리(distance)를 증가 시키지 않는다.")
    public void should_not_increase_car_distance_when_random_number_is_4_less() {
        assertThat(car.move(1)).isEqualTo(0);
    }
}