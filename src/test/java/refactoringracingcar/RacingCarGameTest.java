package refactoringracingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import refactoringracingcar.domain.Car;
import refactoringracingcar.domain.RacingCarGame;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarGameTest {

    RacingCarGame racingCarGame;
    Car car1 = new Car("scoop", 2);
    Car car2 = new Car("poby", 3);
    Car car3 = new Car("shin", 1);
    Car car4 = new Car("hima", 4);
    Car car5 = new Car("scoup", 4);
    List<Car> cars = new ArrayList<>();


    @BeforeEach
    void setUp() {
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
        racingCarGame = new RacingCarGame(cars);
    }

    @DisplayName("우승자동차 구하기")
    @Test
    void determineWinnerTest() {
        assertThat(racingCarGame.determineWinner()).contains(car4, car5);
    }
}
