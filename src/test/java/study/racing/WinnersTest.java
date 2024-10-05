package study.racing;

import org.junit.jupiter.api.Test;
import study.racing.car.Car;
import study.racing.winners.Winners;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {

    @Test
    void winner() {
        // given
        List<Car> cars = List.of(new Car("a", 3), new Car("b", 4));

        // when
        List<Car> winners = Winners.pickWinners(cars);

        //then
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0).getName().getValue()).isEqualTo("b");
    }
}
