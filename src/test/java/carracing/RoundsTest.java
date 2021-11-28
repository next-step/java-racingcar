package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RoundsTest {
    @Test
    @DisplayName("Rounds 객체가 Car 객체의 리스트를 담는지 테스트한다.")
    void rounds() {
        Car car = new Car("car");
        car.stepForward(() -> true);

        List<Car> cars = new ArrayList<>();
        cars.add(car);

        Rounds rounds = new Rounds();
        rounds.add(new Round(cars));

        Round round = rounds.getRounds().get(0);

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

        Rounds rounds = new Rounds();
        rounds.add(new Round(cars));

        List<CarName> winners = rounds.getWinners();
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

        Rounds rounds = new Rounds();
        rounds.add(new Round(cars));

        int longestStep = rounds.getLongestStep();
        assertThat(longestStep).isEqualTo(1);
    }
}