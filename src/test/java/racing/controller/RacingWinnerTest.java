package racing.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.domain.Position;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingWinnerTest {

    static List<Car> cars = new ArrayList<>();
    static Position MAX_POSITION = new Position(5);

    @BeforeEach
    void create_car() {
        cars.add(new Car("car1", new Position(4)));
        cars.add(new Car("car2", new Position(3)));
        cars.add(new Car("car3", new Position(4)));
    }

    @Test
    void 자동차_중_가장_긴_거리() {
        cars.add(new Car("new", MAX_POSITION));
        RacingWinner racingWinner = new RacingWinner();

        List<Car> winnerList = racingWinner.getWinnerList(cars);
        Position winnerCarDistance = winnerList.get(0).getPosition();

        assertThat(winnerCarDistance).isEqualTo(MAX_POSITION);
    }


    @Test
    void 우승자_자동차() {
        Car newCar1 = new Car("new1", MAX_POSITION);
        cars.add(newCar1);
        Car newCar2 = new Car("new2", MAX_POSITION);
        cars.add(newCar2);
        RacingWinner racingWinner = new RacingWinner();

        List<Car> winnerList = racingWinner.getWinnerList(cars);

        assertThat(winnerList).contains(newCar1, newCar2);
    }

}