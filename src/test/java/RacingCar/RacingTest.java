package RacingCar;

import RacingCar.Model.Car;
import RacingCar.Model.Winner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RacingTest {

    @Test
    @DisplayName("우승자의 이름을 잘 알려주는지")
    void addWinnerTest() {

        //given
        Winner winner = new Winner();

        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(new Car(3, "pobi"));
        cars.add(new Car(4, "crong"));
        cars.add(new Car(4, "honux"));
        //when
        winner.makeWinner(cars);

        //then
        String[] expected = {"crong", "honux"};

        for (int i = 0; i < winner.getWinners().size(); i++)
            assertEquals(expected[i], winner.getWinners().get(i).getName());

    }
}