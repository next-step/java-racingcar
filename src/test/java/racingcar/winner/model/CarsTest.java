package racingcar.winner.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import racingcar.winner.view.CarNameInput;

public class CarsTest {

    @Test
    void 주어진이름을가지는차를만든다() {
        List<Car> cars = new CarFactory(new CarNameInput("1,2,3").parse()).build();

        assertThat(new Cars(cars).getCars()).hasSize(3);
    }

    @Test
    void 우승자를찾는다() {
        Car winnerCar1 = new Car(new CarName("A"), new MoveResult(5));
        Car winnerCar2 = new Car(new CarName("B"), new MoveResult(5));
        Car loser = new Car(new CarName("C"), new MoveResult(1));

        List<Car> testCars = List.of(loser, winnerCar1, winnerCar2);

        assertThat(new Cars(testCars).findWinner()).containsOnly(winnerCar1, winnerCar2);
    }
}
