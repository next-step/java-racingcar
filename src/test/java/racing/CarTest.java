package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    Car car;

    @BeforeEach
    void before() {
        car = new Car();
    }

    @Test
    @DisplayName("Car 객체 생성 시 position은 0 && 파라미터와 Car의 위치가 일치하면 true")
    void Car_constructor() {
        assertThat(car.hasPosition(0)).isTrue();
        assertThat(car.hasPosition(1)).isFalse();
    }

    @Test
    @DisplayName("forward() 호출 시 position 1 증가")
    void forward() {
        int startPosition = 0;
        assertThat(car.hasPosition(startPosition)).isTrue();
        car.forward();
        assertThat(car.hasPosition(startPosition + 1)).isTrue();
    }

    @Test
    @DisplayName("carPositions() 호출 시 List<Car>를 List<Position>으로 변환")
    void carPositions() {
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();

        car1.forward();
        car1.forward();
        car2.forward();

        List<Car> carList = List.of(car1, car2, car3);

        List<Position> positions = Car.carPositions(carList);

        assertThat(positions).containsSubsequence(new Position(2), new Position(1), new Position(0));

    }

}