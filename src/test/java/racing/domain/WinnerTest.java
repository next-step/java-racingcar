package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerTest {

    Cars cars;

    @BeforeEach
    void beforeEach() {
        String[] names = {"RedCar", "BlueCar", "BlackCar"};
        cars = new Cars(names);
    }

    @Test
    void 우승자_1명() {
        List<Car> carList = cars.getCarList();
        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).move(i);
        }
        String maxCarName = carList.get(carList.size()-1).getName();
        Winner winner = new Winner(cars);
        List<String> winners = winner.compareWinner();

        assertThat(winners).hasSize(1);
        assertThat(winners.get(0)).isEqualTo(maxCarName);
    }

    @Test
    void 우승자_3명() {
        List<Car> carList = cars.getCarList();
        for (Car car : cars.getCarList()) {
            car.move(1);
        }
        Winner winner = new Winner(cars);
        List<String> winners = winner.compareWinner();

        for (int i = 0; i < carList.size(); i++) {
            assertThat(winners.get(i)).isEqualTo(carList.get(i).getName());
        }
    }
}