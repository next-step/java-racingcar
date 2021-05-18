package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {

    @DisplayName("우승자 뽑기")
    @Test
    void getWinner() {
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("1", 4));
        cars.add(new Car("2", 3));
        cars.add(new Car("3", 2));
        cars.add(new Car("4", 1));

        Winners winners = new Winners(cars);

        assertThat(winners.winners()).contains("1");

    }

}
