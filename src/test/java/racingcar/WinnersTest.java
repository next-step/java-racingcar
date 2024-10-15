package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Winners;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {

    @Test
    @DisplayName("가장 많은 거리를 간 자동차를 우승자로 반환하는지 확인")
    void findWinner() {
        Car testCar1 = new Car("yun1", 3);
        Car testCar2 = new Car("yun2", 2);
        Car testCar3 = new Car("yun3", 1);
        List<Car> cars = Arrays.asList(testCar1, testCar2, testCar3);

        List<Car> winners = Winners.findWinners(cars);

        assertThat(winners).hasSize(1);
        assertThat(winners).contains(testCar1);
    }

}
