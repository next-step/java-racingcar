package study.racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.RacingCar;
import racingcar.domain.RandomMove;
import racingcar.domain.Winner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {
    private static final int STANDARD_MOVEMENT = 0;
    private static final int BOUND = 1;
    private static final RandomMove RANDOM_MOVE = new RandomMove(STANDARD_MOVEMENT, BOUND);
    private String NAME = "pobi,crong";
    private Winner winner = new Winner();
    private RacingCar racingCar;

    @BeforeEach
    void setup() {
        racingCar = new RacingCar(NAME, RANDOM_MOVE);
    }

    @Test
    @DisplayName("우승자 찾기")
    void findWinner() {
        List<Car> cars = racingCar.getCarList();
        cars.get(0).move();
        assertThat(winner.findWinner(cars)).isEqualTo("pobi");
    }
}
