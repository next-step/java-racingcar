package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    @Test
    @DisplayName("우승자가 1명이면 우승자를 1명 반환한다.")
    void getWinnerOne() {
        //arranger
        Car car1 = new Car("car1");
        car1.move(4);
        car1.move(4);

        Car car2 = new Car("car2");
        car2.move(4);

        Car car3 = new Car("car3");
        car3.move(4);

        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        //act
        Game game = new Game(cars);
        List<Car> winner = game.getWinner();

        //assert
        assertThat(winner).hasSize(1);
        assertThat(winner.get(0).getName()).isEqualTo("car1");
    }

    @Test
    @DisplayName("우승자가 2명이면 우승자를 2명 반환한다.")
    void getWinnerTwo() {
        //arranger
        Car car1 = new Car("car1");
        car1.move(4);
        car1.move(4);

        Car car2 = new Car("car2");
        car2.move(4);
        car2.move(4);

        Car car3 = new Car("car3");
        car3.move(4);

        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        //act
        Game game = new Game(cars);
        List<Car> winner = game.getWinner();

        //assert
        assertThat(winner).hasSize(2);
        assertThat(winner.get(0).getName()).isEqualTo("car1");
        assertThat(winner.get(1).getName()).isEqualTo("car2");

    }
}