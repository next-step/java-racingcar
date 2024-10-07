package step4racinggamewinner;

import org.junit.jupiter.api.Test;
import step4racinggamewinner.random.RandomGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {
    final static int TEST_CAR_COUNT = 3;
    public static final int GO = 1;
    public static final int STOP = 0;
    RandomGenerator randomGenerator;
    Cars cars;
    Winners winners;

    @Test
    void 우승자_찾기() {
        Car red = new Car("red", 4);
        Car kaki = new Car("kaki", 2);
        Car blue = new Car("blue", 4);
        cars = new Cars(red, kaki, blue);
        winners = new Winners(cars);
        assertThat(winners.findWinner()).isEqualTo(List.of("red", "blue"));
    }


}
