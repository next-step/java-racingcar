package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    @DisplayName("자동차 전진")
    void canMoveForward () {
        Car car = new NextStepCar();
        assertThat(car.moveForward()).isEqualTo(1);
        assertThat(car.moveForward()).isEqualTo(2);
        assertThat(car.moveForward()).isEqualTo(3);
        assertThat(car.moveForward()).isEqualTo(4);
        assertThat(car.moveForward()).isEqualTo(5);
    }

    @Test
    @DisplayName("여러대의 자동차 전진")
    void isMoveOrStopCar () {
        List<Car> cars = new ArrayList<>();
        cars.add(new NextStepCar());
        cars.add(new NextStepCar());
        cars.add(new NextStepCar());
        cars.add(new NextStepCar());
        cars.add(new NextStepCar());

        for(Car car: cars) {
            assertThat(car.moveForward()).isEqualTo(1);
            assertThat(car.moveForward()).isEqualTo(2);
            assertThat(car.moveForward()).isEqualTo(3);
            assertThat(car.moveForward()).isEqualTo(4);
            assertThat(car.moveForward()).isEqualTo(5);
        }
        assertThat(cars.get(0).getPosition()).isEqualTo(5);
        assertThat(cars.get(1).getPosition()).isEqualTo(5);
        assertThat(cars.get(2).getPosition()).isEqualTo(5);
        assertThat(cars.get(3).getPosition()).isEqualTo(5);
        assertThat(cars.get(4).getPosition()).isEqualTo(5);

    }
}