package car_racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsForGameTest {

    @Test
    @DisplayName("When create Cars with numberOfCar, default status is set")
    void createCars() {
        // given
        String name = "";
        Car car0 = new Car(name);
        Car car1 = new Car(name);
        Car car2 = new Car(name);
        List<Car> carObjects = new ArrayList<Car>() {{
            add(car0);
            add(car1);
            add(car2);
        }};

        // when
        CarsForGame carsForGame = new CarsForGame(carObjects);

        // then
        assertThat(carsForGame.getCars()).isEqualTo(carObjects);
        assertThat(carsForGame.getCars().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("when playOneRound with TestMoveStrategy, cars position moves to 1")
    void playOneRound() {
        // given
        String name = "";
        Car car0 = new Car(1, name);
        Car car1 = new Car(2, name);
        List<Car> carObjects = new ArrayList<Car>() {{
            add(car0);
            add(car1);
        }};
        CarsForGame carsForGame = new CarsForGame(carObjects);

        // when
        carsForGame.playOneRound(() -> true);

        // then
        assertThat(carsForGame.getCars().get(0).getPosition()).isEqualTo(2);
        assertThat(carsForGame.getCars().get(1).getPosition()).isEqualTo(3);
    }

}