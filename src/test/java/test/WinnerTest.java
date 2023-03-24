package test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.domain.Car;
import racingCar.domain.Winner;
import racingCar.view.ResultView;

public class WinnerTest {

    @DisplayName("자동차 한 대가 우승한 경우")
    @Test
    void winner() {
        List<Car> cars = Arrays.asList(
            new Car("pobi", 2),
            new Car("crong", 3),
            new Car("honux", 1)
        );
        List<String> winner = new Winner().getWinner(cars, 3);
        assertThat(new ResultView().toString(winner)).isEqualTo("crong");
    }

    @DisplayName("자동차 여러대가 우승한 경우")
    @Test
    void winners() {
        List<Car> cars = Arrays.asList(
            new Car("pobi", 3),
            new Car("crong", 3),
            new Car("honux", 1)
        );

        List<String> winners = new Winner().getWinner(cars, 3);
        assertThat(new ResultView().toString(winners)).isEqualTo("pobi, crong");
    }
}
