package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.service.Winner;

import static org.assertj.core.api.Assertions.*;
import java.util.*;

public class WinnerTest {
    @Test
    @DisplayName("가장 많이 전진한 자동차가 우승하는지 확인한다.")
    public void GetWinner() {
        List<Car> carList = new ArrayList<>();
        Car winner = new Car("car1");

        carList.add(winner);
        carList.add(new Car("car2"));
        carList.add(new Car("car3"));

        winner.move(5);

        assertThat(Winner.getWinners(carList)).isEqualTo("car1");
    }
}
