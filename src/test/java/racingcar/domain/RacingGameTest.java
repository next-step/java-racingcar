package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingGameTest {
    @Test
    void getWinners() {
        List<Car> cars= new ArrayList<>();
        Car car1 = new Car("car1");
        car1.run(true);
        Car car2 = new Car("car2");
        car2.run(false);
        Car car3 = new Car("car3");
        car3.run(true);

        RacingGame racingGame = new RacingGame(Arrays.asList(car1, car2, car3));
        List<Car> winners = racingGame.getWinners();
        assertThat(winners).hasSize(2);
        assertThat(winners).contains(car1);
        assertThat(winners).contains(car3);
    }
}
