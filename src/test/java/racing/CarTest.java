package racing;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void 자동차_생성_이름부여() {

        RaceInfo raceInfo = new RaceInfo(new String[]{"test1", "test2", "test3"}, 5);
        Car car = new Car();
        List<Car> cars = car.generateNamedCar(raceInfo);

        assertThat(cars.get(0).carName()).isEqualTo("test1");
        assertThat(cars.get(1).carName()).isEqualTo("test2");
        assertThat(cars.get(2).carName()).isEqualTo("test3");
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