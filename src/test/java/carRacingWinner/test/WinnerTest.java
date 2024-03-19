package carRacingWinner.test;

import carRacingWinner.domain.Car;
import carRacingWinner.domain.Winner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class WinnerTest {

    @Test
    @DisplayName("우승자 위치")
    public void winnerLocation() {
        Winner winner = new Winner();

        List<Car> list = new ArrayList<>();

        list.add(new Car("a"));
        list.add(new Car("b"));
        list.add(new Car("c"));
        Car car = new Car("dobi");
        list.add(car);
        list.get(3).move(6);
        list.get(3).move(6);
        list.get(3).move(6);

        assertThat(winner.location(list)).isEqualTo(3);
    }

    @Test
    @DisplayName("우승자 리스트")
    public void winnerList() {
        Winner winner = new Winner();
        List<Car> cars = new ArrayList<>();
        Car expectedWinner = new Car("abc");
        cars.add(expectedWinner);
        winner.printWinner(cars);

        assertThat(winner.getWinner()).contains(expectedWinner);
    }
}
