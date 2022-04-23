package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {
    @Test
    @DisplayName("우승자를 찾는다.")
    void winnerTest() {
        List<Car> carList = new ArrayList<>();
        Car winner = new Car(new CarName("car1"), new Position(4));
        carList.add(winner);
        carList.add(new Car(new CarName("car2"), new Position(1)));

        Cars cars = new Cars(carList);
        List<Car> winnerCar = Winners.findWinners(cars);

        assertThat(winnerCar.get(0)).isEqualTo(winner);
    }

    @Test
    @DisplayName("우승자는 두명 이상일 수 있다.")
    void coWinnerTest() {
        List<Car> carList = new ArrayList<>();

        carList.add(new Car(new CarName("car1"), new Position(4)));
        carList.add(new Car(new CarName("car2"), new Position(4)));

        Cars cars = new Cars(carList);
        List<Car> winnerCar = Winners.findWinners(cars);

        assertThat(winnerCar.size()).isEqualTo(2);
    }
}
