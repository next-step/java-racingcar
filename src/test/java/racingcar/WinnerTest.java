package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Winner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class WinnerTest {
    @Test
    void getWinners() {
        Car red = new Car(3, "red");
        Car blue = new Car(5, "blue");
        Car black = new Car(3, "black");

        Winner winner = new Winner();
        List<Car> winners = winner.findWinners(Arrays.asList(red, black, blue));

        assertThat(winners).contains(blue);
    }
}
