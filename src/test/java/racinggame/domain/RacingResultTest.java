package racinggame.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingResultTest {
    @Test
    public void findWinners() {
        Car pobi = new Car("pobi", 8);
        Car honux = new Car("honux", 7);
        Car crong = new Car("crong", 8);
        List<Car> cars = Arrays.asList(pobi, honux, crong);
        RacingResult result = new RacingResult(cars);
        assertThat(result.findWinners()).hasSize(2);
        assertThat(result.findWinners()).contains(pobi, crong);
    }

    @Test
    public void createDisplayWinnerNames() {
        List<Car> cars = Arrays.asList(
                new Car("pobi", 8),
                new Car("honux", 7),
                new Car("crong", 8)
        );
        RacingResult result = new RacingResult(cars);
        assertThat(result.createDisplayWinnerNames()).contains("pobi,crong");
    }
}
