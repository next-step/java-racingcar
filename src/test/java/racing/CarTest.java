package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.behavior.CarMovable;
import racing.behavior.Movable;
import racing.domain.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static racing.domain.Car.listOf;

public class CarTest {

    @DisplayName("자동차 위치 초기화 상태 생성 테스트")
    @Test
    void initialCar() {
        final Car car = Car.of(new CarMovable());

        assertThat(car.getLocation()).isZero();
        assertThat(car).isNotNull();
    }

    @DisplayName("경주할 자동차 들의 초기화 상태 생성 테스트")
    @Test
    void initialCars() {
        final List<Car> cars = listOf(3, new CarMovable());

        assertThat(cars.isEmpty()).isFalse();
        assertThat(cars).hasSize(3);
    }
}
