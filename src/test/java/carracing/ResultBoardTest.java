package carracing;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ResultBoardTest {
    @Test
    void resultBoard() {
        Car car = new Car("car");
        car.stepForwardByRandomNumber(Car.MIN_FORWARD);

        List<Car> cars = new ArrayList<>();
        cars.add(car);

        ResultBoard resultBoard = new ResultBoard();
        resultBoard.add(new Round(cars));

        List<Round> rounds = resultBoard.getRounds();
        Round round = rounds.get(0);

        assertThat(round.getStep("car")).isEqualTo(1);
    }

    @Test
    void getWinnersWithOneWinner() {
        Car car = new Car("car");
        car.stepForwardByRandomNumber(Car.MIN_FORWARD);

        Car car1 = new Car("car1");
        car.stepForwardByRandomNumber(Car.MIN_FORWARD - 1);

        List<Car> cars = new ArrayList<>();
        cars.add(car);
        cars.add(car1);

        ResultBoard resultBoard = new ResultBoard();
        resultBoard.add(new Round(cars));

        List<CarName> winners = resultBoard.getWinners();
        assertThat(winners.get(0).getName()).isEqualTo("car");
    }
}