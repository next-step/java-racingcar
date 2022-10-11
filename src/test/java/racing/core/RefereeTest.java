package racing.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RefereeTest {

    private final Referee referee = new Referee();

    @Test
    @DisplayName("정상적인 한명의 우승자를 반환하는지 확인")
    void testGettingOneWinner() {
        List<Car> cars = new ArrayList<>();
        Car car1 = new Car("jason");
        Car car2 = new Car("ethan");
        Car car3 = new Car("pat");
        Mover mover = new Mover();
        mover.decideMove(car1, 9);
        mover.decideMove(car1, 9);
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        List<Car> winners = referee.getWinners(cars);

        assertThat(winners).hasSize(1);
        assertThat(winners).containsExactly(car1);
    }

    @Test
    @DisplayName("정상적인 복수의 우승자를 반환하는지 확인")
    void testGettingWinners() {
        List<Car> cars = new ArrayList<>();
        Car car1 = new Car("jason");
        Car car2 = new Car("ethan");
        Car car3 = new Car("pat");
        Mover mover = new Mover();
        mover.decideMove(car1, 9);
        mover.decideMove(car1, 9);
        mover.decideMove(car2, 5);
        mover.decideMove(car2, 7);
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        List<Car> winners = referee.getWinners(cars);

        assertThat(winners).hasSize(2);
        assertThat(winners).containsExactly(car1, car2);
    }
}
