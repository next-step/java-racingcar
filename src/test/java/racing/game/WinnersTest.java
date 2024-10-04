package racing.game;

import org.junit.jupiter.api.Test;
import racing.car.Car;
import racing.car.Cars;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {

    @Test
    void getWinners() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("bmw", 5));
        carList.add(new Car("audi", 3));
        carList.add(new Car("hy", 5));

        Cars cars = new Cars(carList);
        Winners winners = new Winners();
        winners.getWinners(cars);

        assertThat(winners.getWinners(cars).getItems()).contains(new Car("bmw", 5), new Car("hy", 5));
    }
}
