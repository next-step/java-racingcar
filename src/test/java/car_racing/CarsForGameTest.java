package car_racing;

import car_racing.model.Car;
import car_racing.model.CarsForGame;
import car_racing.model.Position;
import org.assertj.core.util.Lists;
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
        assertThat(carsForGame.getCars().get(0).getPosition()).isEqualTo(new Position(2));
        assertThat(carsForGame.getCars().get(1).getPosition()).isEqualTo(new Position(3));
    }

    @Test
    void findWinners() {
        // given
        Car car1 = new Car(1, "a");
        Car car2 = new Car(2, "b");
        Car car3 = new Car(3, "c");
        Car car4 = new Car(3, "d");
        Car car5 = new Car(0, "e");
        CarsForGame cars = new CarsForGame(Lists.list(
                car1, car2, car3, car4, car5
        ));

        // when
        List<Car> winners = cars.findWinners();

        // then
        assertThat(winners.get(0)).isEqualTo(car3);
        assertThat(winners.get(1)).isEqualTo(car4);
    }

    @Test
    void findWinners_when_no_cars() {
        // given
        CarsForGame cars = new CarsForGame();

        // when
        List<Car> winners = cars.findWinners();

        // then
        assertThat(winners).isEmpty();
    }

}