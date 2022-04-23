package core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {

    @Test
    @DisplayName("position 이 가장 큰 차들이 우승자가 된다 1")
    void decideWinners1() {
        //given
        Car car1 = TestObjectGenerator.generateCar("a", 4);
        Car car2 = TestObjectGenerator.generateCar("b", 3);
        Car car3 = TestObjectGenerator.generateCar("c", 2);
        Cars cars = Cars.fromCars(Arrays.asList(car1, car2, car3));

        //when
        Winners winners = Winners.decideWinners(cars);

        //then
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.getCars()).contains(car1);
    }

    @Test
    @DisplayName("position 이 가장 큰 차들이 우승자가 된다 2")
    void decideWinners2() {
        //given
        Car car1 = TestObjectGenerator.generateCar("a", 4);
        Car car2 = TestObjectGenerator.generateCar("b", 2);
        Car car3 = TestObjectGenerator.generateCar("c", 4);
        Cars cars = Cars.fromCars(Arrays.asList(car1, car2, car3));

        List<Car> winnerCars = new ArrayList<>();
        winnerCars.add(car1);
        winnerCars.add(car3);

        //when
        Winners result = Winners.decideWinners(cars);

        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.getCars()).containsAll(winnerCars);
    }

    @Test
    @DisplayName("자동차들의 이름이 모두 반환돼야 한다")
    void names() {
        //given
        Winners winners = TestObjectGenerator.generateWinners();
        CarName carName1 = CarName.create("a");
        CarName carName2 = CarName.create("b");
        List<CarName> winnerNames = Arrays.asList(carName1, carName2);

        //when
        List<CarName> result = winners.names();

        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).containsAll(winnerNames);
    }

    @Test
    @DisplayName("자동차들의 이름이 모두 String 으로 반환돼야 한다")
    void namesAsString() {
        //given
        Winners winners = TestObjectGenerator.generateWinners();
        List<String> winnerNames = Arrays.asList("a", "b");

        //when
        List<String> result = winners.namesAsString();

        //then
        assertThat(result.size()).isEqualTo(winnerNames.size());
        assertThat(result).containsAll(winnerNames);
    }
}