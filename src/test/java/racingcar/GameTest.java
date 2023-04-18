package racingcar;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    @Test
    @DisplayName("우승자가 1명이면 우승자를 1명 반환한다.")
    void getWinnerOne() {
        //arrange
        Car car1 = createEndCar("car1", 2);
        Car car2 = createEndCar("car2", 1);
        Car car3 = createEndCar("car3", 1);
        List<Car> endRaceCarList = Lists.newArrayList(car1, car2, car3);

        //act
        Game game = new Game(endRaceCarList);
        List<Car> winner = game.getWinner();

        //assert
        assertThat(winner).hasSize(1);
        assertThat(winner.get(0).getName()).isEqualTo("car1");
    }

    @Test
    @DisplayName("우승자가 2명이면 우승자를 2명 반환한다.")
    void getWinnerTwo() {
        //arrange
        Car car1 = createEndCar("car1", 2);
        Car car2 = createEndCar("car2", 2);
        Car car3 = createEndCar("car3", 1);
        List<Car> endRaceCarList = Lists.newArrayList(car1, car2, car3);

        //act
        Game game = new Game(endRaceCarList);
        List<Car> winner = game.getWinner();

        //assert
        assertThat(winner).hasSize(2);
        assertThat(winner.get(0).getName()).isEqualTo("car1");
        assertThat(winner.get(1).getName()).isEqualTo("car2");

    }

    private Car createEndCar(String name, int position) {
        Car car1 = new Car(name);
        for (int i = 0; i < position; i++) {
            car1.move(4);
        }
        return car1;
    }
}
