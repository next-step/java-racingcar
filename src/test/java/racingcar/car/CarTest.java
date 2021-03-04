package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    @DisplayName("자동차는 4이상이 입력되어야 전진")
    void canMoveForward () {
        Car car = new NextStepCar();
        assertThat(car.moveForward(4)).isEqualTo(1);
        assertThat(car.moveForward(4)).isEqualTo(2);
        assertThat(car.moveForward(4)).isEqualTo(3);
        assertThat(car.moveForward(4)).isEqualTo(4);
        assertThat(car.moveForward(4)).isEqualTo(5);
        assertThat(car.moveForward(1)).isEqualTo(5);
        assertThat(car.moveForward(1)).isEqualTo(5);
        assertThat(car.moveForward(1)).isEqualTo(5);
        assertThat(car.moveForward(1)).isEqualTo(5);
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
            assertThat(car.moveForward(4)).isEqualTo(1);
            assertThat(car.moveForward(5)).isEqualTo(2);
            assertThat(car.moveForward(6)).isEqualTo(3);
            assertThat(car.moveForward(7)).isEqualTo(4);
            assertThat(car.moveForward(8)).isEqualTo(5);
        }
        assertThat(cars.get(0).getPosition()).isEqualTo(5);
        assertThat(cars.get(1).getPosition()).isEqualTo(5);
        assertThat(cars.get(2).getPosition()).isEqualTo(5);
        assertThat(cars.get(3).getPosition()).isEqualTo(5);
        assertThat(cars.get(4).getPosition()).isEqualTo(5);
    }

    @Test
    @DisplayName("전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.")
    void mustOverFourCanMoveForward() {
        Random random = new Random();
        int randomNumber = random.nextInt(10);
        if (randomNumber >= 4) {
            Car car = new NextStepCar();
            assertThat(car.moveForward(randomNumber)).isEqualTo(1);
        }
        if (randomNumber < 4) {
            Car car = new NextStepCar();
            assertThat(car.moveForward(randomNumber)).isEqualTo(0);
        }
    }
}