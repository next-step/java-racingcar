package carracing;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultBoardTest {
    @Test
    void resultBoard() {
        Car car = new Car("car");
        car.stepForward(() -> true);

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
        car.stepForward(() -> true);

        Car car1 = new Car("car1");
        car.stepForward(() -> false);

        List<Car> cars = new ArrayList<>();
        cars.add(car);
        cars.add(car1);

        ResultBoard resultBoard = new ResultBoard();
        resultBoard.add(new Round(cars));

        List<CarName> winners = resultBoard.getWinners();
        assertThat(winners.get(0).getName()).isEqualTo("car");
    }

    @Test
    void getLongestStep() {
        Car car = new Car("car");
        car.stepForward(() -> true);

        Car car1 = new Car("car1");
        car.stepForward(() -> false);

        List<Car> cars = new ArrayList<>();
        cars.add(car);
        cars.add(car1);

        ResultBoard resultBoard = new ResultBoard();
        resultBoard.add(new Round(cars));

        int longestStep = resultBoard.getLongestStep();
        assertThat(longestStep).isEqualTo(1);
    }
}