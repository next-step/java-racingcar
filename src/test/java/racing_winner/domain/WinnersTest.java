package racing_winner.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WinnersTest {

    @Test
    @DisplayName("level이 가장 높은 차가 우승한다.")
    void getWinners(){

        Car car1 = new Car("a",3);
        Car car2 = new Car("b",4);
        List<Car> cars = List.of(car1, car2);

        Assertions.assertThat(Winners.getWinners(cars)).contains(car2);

    }
}