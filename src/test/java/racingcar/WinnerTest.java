package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.*;

public class WinnerTest {

    @DisplayName("승자 1명 체크")
    @Test
    void 승자_1명() {
        Car winner = new Car("win");
        winner.move();
        winner.move();
        Car loser = new Car("lose");
        loser.move();
        List<Car> cars = new ArrayList<>();
        cars.add(winner);
        cars.add(loser);
        List<Car> winners = Winner.getWinner(cars);
        Assertions.assertThat(winners).contains(winner);
    }

    @DisplayName("승자 2명 체크")
    @Test
    void 승자_2명() {
        Car winner1 = new Car("win1");
        winner1.move();
        Car winner2 = new Car("win2");
        winner2.move();
        List<Car> cars = new ArrayList<>();
        cars.add(winner1);
        cars.add(winner2);
        List<Car> winners = Winner.getWinner(cars);
        Assertions.assertThat(winners.size()).isEqualTo(2);
        Assertions.assertThat(winners).contains(winner1);
        Assertions.assertThat(winners).contains(winner2);
    }
}
