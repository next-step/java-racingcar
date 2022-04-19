package racing.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.domain.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingWinnerTest {

    static List<Car> cars = new ArrayList<>();
    static int MAX_DISTANCE = 5;

    @BeforeEach
    void create_car() {
        addCar("car1", 4);
        addCar("car2", 3);
        addCar("car3", 4);
    }

    private Car addCar(String carName, int distance) {
        Car car = new Car(carName);
        for (int i = 0; i < distance; i++) {
            car.move(Car.FORWARD_STANDARD_NUMBER);
        }
        cars.add(car);
        return car;
    }

    @Test
    void 자동차_중_가장_긴_거리() {
        addCar("newCar", MAX_DISTANCE);
        RacingWinner racingWinner = new RacingWinner();

        List<Car> winnerList = racingWinner.getWinnerList(cars);
        int winnerCarDistance = winnerList.get(0).getDistance();

        assertThat(winnerCarDistance).isEqualTo(MAX_DISTANCE);
    }


    @Test
    void 우승자_자동차() {
        Car newCar1 = addCar("newCar1", MAX_DISTANCE);
        Car newCar2 = addCar("newCar2", MAX_DISTANCE);
        RacingWinner racingWinner = new RacingWinner();

        List<Car> winnerList = racingWinner.getWinnerList(cars);

        assertThat(winnerList).contains(newCar1, newCar2);
    }

}