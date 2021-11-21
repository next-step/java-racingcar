package carracing;

import carracing.domain.Car;
import carracing.domain.Winners;
import carracing.exception.CarNameFormatException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class WinnersTest {

    @Test
    @DisplayName("가장 많이 주행한 자동차가 우승자")
    void winners() throws CarNameFormatException {
        List<Car> winnerCars = new ArrayList<>();
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        car1.driving(4);

        winnerCars.add(car1);
        winnerCars.add(car2);
        Winners winners = new Winners(winnerCars);

        Assertions.assertThat(winners.getWinners()).contains(car1);
        Assertions.assertThat(winners.getWinners()).doesNotContain(car2);
    }

    @Test
    @DisplayName("우승자는 2이상일 수 있다")
    void manyWinners() throws CarNameFormatException {
        List<Car> winnerCars = new ArrayList<>();
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");
        car1.driving(4);
        car2.driving(4);

        winnerCars.add(car1);
        winnerCars.add(car2);
        Winners winners = new Winners(winnerCars);

        Assertions.assertThat(winners.getWinners()).contains(car1, car2);
        Assertions.assertThat(winners.getWinners()).doesNotContain(car3);
    }
}
