package study.racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car;
import racingcar.RacingCar;
import racingcar.RandomMove;
import racingcar.Winner;

import java.util.List;

public class WinnerTest {
    private static final int STANDARD_MOVEMENT = 0;
    private static final int BOUND = 1;
    private static final RandomMove RANDOM_MOVE = new RandomMove(STANDARD_MOVEMENT, BOUND);
    private Car car;
    private String NAME = "pobi,crong";
    private Winner winner = new Winner();
    private RacingCar racingCar;

    @BeforeEach
    void setup() {
        car = new Car(NAME);
        racingCar = new RacingCar(NAME, RANDOM_MOVE);
    }

    @Test
    @DisplayName("우승자 찾기")
    void findWinner() {
        List<Car> cars = racingCar.getCarList();
        cars.get(0).move();
        winner.findWinner(cars);
    }
}
