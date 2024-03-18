package carRacingWinner.test;

import carRacingWinner.entity.Car;
import carRacingWinner.entity.Winner;
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
        Car car = new Car("dobi") {
            @Override
            protected int moveChance() {
                return 5;
            }
        };
        list.add(car);
        list.get(3).move();
        list.get(3).move();
        list.get(3).move();

        assertThat(winner.location(list)).isEqualTo(3);
    }

    @Test
    @DisplayName("우승자 리스트")
    public void winnerList() {
        Winner winner = new Winner();
        List<Car> cars = new ArrayList<>();
        Car expectedWinner = new Car("abc");
        cars.add(expectedWinner);

        assertThat(winner.printWinner(cars)).contains(expectedWinner);
    }
}
