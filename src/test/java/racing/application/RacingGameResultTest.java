package racing.application;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameResultTest {
    @Test
    public void 승자확인() {
        //given
        Car winner = new Car("pobi");
        winner.move();

        List<Car> cars = new ArrayList();
        cars.add(winner);
        cars.add(new Car("crong"));
        cars.add(new Car("honux"));

        RacingGameResult result = new RacingGameResult();

        //when
        result.judge(cars);

        //then
        assertThat(result.getWinners()).isEqualTo("pobi");
    }
}