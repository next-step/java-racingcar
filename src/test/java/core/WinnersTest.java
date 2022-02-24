package core;

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
        Car car1 = TestCarGenerator.generate("a", 4);
        Car car2 = TestCarGenerator.generate("b", 3);
        Car car3 = TestCarGenerator.generate("c", 2);
        Cars cars = Cars.fromCars(Arrays.asList(car1, car2, car3));

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
        Car car1 = TestCarGenerator.generate("a", 4);
        Car car2 = TestCarGenerator.generate("b", 2);
        Car car3 = TestCarGenerator.generate("c", 4);
        Cars cars = Cars.fromCars(Arrays.asList(car1, car2, car3));

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