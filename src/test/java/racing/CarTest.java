package racing;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void 자동차_생성() {

        Car car = new Car();
        List<Car> cars = car.generateCar(3);

        for (int i = 0; i < 3; i++) {
            int number = cars.get(i).carNumber();
            assertThat(number).isEqualTo(i);
        }

        for (int i = 0; i < 3; i++) {
            int distance = cars.get(i).carDistance();
            assertThat(distance).isEqualTo(0);
        }
    }

    @Test
    void 자동차_전진() {
        Car car1 = new Car(1);
        car1.move(5);
        int distance1 = car1.carDistance();
        assertThat(distance1).isEqualTo(1);

        Car car2 = new Car(2);
        car2.move(3);
        int distance2 = car2.carDistance();
        assertThat(distance2).isEqualTo(0);
    }
}