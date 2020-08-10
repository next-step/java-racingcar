package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.behavior.CarMovable;
import racing.behavior.Movable;
import racing.domain.Car;
import racing.domain.RacingCars;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
        final List<Car> cars = RacingCars.of(3).getCars();

        assertThat(cars.isEmpty()).isFalse();
        assertThat(cars).hasSize(3);
    }

    @DisplayName("자동차 전진 하는 경우 확인 테스트")
    @Test
    void moveCar() {
        final Movable movable = () -> true;
        final Car car = new Car(0, movable);
        car.move();

        assertThat(car.getLocation()).isOne();
    }
}
