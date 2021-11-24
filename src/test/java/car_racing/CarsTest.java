package car_racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("When create Cars with numberOfCar, default status is set")
    void createCars() {
        // given
        Name name = new Name("");
        Car car0 = new Car(name);
        Car car1 = new Car(name);
        Car car2 = new Car(name);

        List<Car> carObjects = new ArrayList<Car>() {{
            add(car0);
            add(car1);
            add(car2);
        }};

        // when
        Cars cars = new Cars(carObjects);

        // then
        assertThat(cars.getCars()).isEqualTo(carObjects);
        assertThat(cars.getCars().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("when playOneRound with TestMoveStrategy, cars position moves to 1")
    void playOneRound() {
        // given
        Name name = new Name("");
        Car car0 = new Car(1, name);
        Car car1 = new Car(2, name);

        List<Car> carObjects = new ArrayList<Car>() {{
            add(car0);
            add(car1);
        }};
        Cars cars = new Cars(carObjects);

        // when
        cars.playOneRound(() -> true);

        // then
        assertThat(cars.getCars().get(0).getPosition()).isEqualTo(2);
        assertThat(cars.getCars().get(1).getPosition()).isEqualTo(3);
    }

}