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

        Winner winner = new Winner(Arrays.asList(red, black, blue));
        List<Car> winners = winner.findWinners();

        assertThat(winners).contains(blue);
    }

    @Test
    void string_join() {

        Car red = new Car(3, "red");
        Car blue = new Car(5, "blue");
        Car black = new Car(5, "black");

        Winner winner = new Winner(Arrays.asList(red, blue, black));

        assertThat(winner.joinWinners(winner.findWinners())).isEqualTo("blue,black");

    }
}
