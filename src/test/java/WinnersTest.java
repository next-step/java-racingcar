import core.Car;
import core.Cars;
import core.Winners;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {

    @Test
    @DisplayName("position 이 가장 큰 차들이 우승자가 된다 1")
    void decideWinners1() {
        //given
        List<String> carNames = Arrays.asList("a", "b", "c");
        Cars cars = Cars.of(carNames);

        for (int i = 0; i < 4; i++) {
            cars.getCars().get(0).move(Car.BASE_MOVE_VALUE);
        }
        for (int i = 0; i < 3; i++) {
            cars.getCars().get(1).move(Car.BASE_MOVE_VALUE);
        }
        for (int i = 0; i < 2; i++) {
            cars.getCars().get(2).move(Car.BASE_MOVE_VALUE);
        }

        List<String> winnerCarNames = new ArrayList<>();
        winnerCarNames.add("a");

        //when
        Winners winners = Winners.decideWinners(cars);

        //then
        assertThat(winners.getCars().size()).isEqualTo(1);
        winners.getCars().forEach(car -> assertThat(winnerCarNames).contains(car.getCarName()));
    }

    @Test
    @DisplayName("position 이 가장 큰 차들이 우승자가 된다 2")
    void decideWinners2() {
        //given
        List<String> carNames = Arrays.asList("a", "b", "c");
        Cars cars = Cars.of(carNames);

        for (int i = 0; i < 4; i++) {
            cars.getCars().get(0).move(Car.BASE_MOVE_VALUE);
        }
        for (int i = 0; i < 2; i++) {
            cars.getCars().get(1).move(Car.BASE_MOVE_VALUE);
        }
        for (int i = 0; i < 4; i++) {
            cars.getCars().get(2).move(Car.BASE_MOVE_VALUE);
        }

        List<String> winnerCarNames = new ArrayList<>();
        winnerCarNames.add("a");
        winnerCarNames.add("c");

        //when
        Winners winners = Winners.decideWinners(cars);

        //then
        assertThat(winners.getCars().size()).isEqualTo(2);
        winners.getCars().forEach(car -> assertThat(winnerCarNames).contains(car.getCarName()));
    }
}