package racingcar.race;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class ResultTest {

    RacingCars racingCars;

    @BeforeEach
    void setUp() {
        List<Car> carList = List.of(
                new Car("a", 1)
                , new Car("b", 1)
                , new Car("c", 2));

        racingCars = new RacingCars(carList);
    }

    @Test
    @DisplayName("우승자 구하기")
    void judgeWinner() {
        Result result = new Result();

        List<Car> cars = result.judgeWinner(racingCars);

        Assertions.assertThat(cars.size()).isEqualTo(1);
        Assertions.assertThat(cars.get(0).getName()).isEqualTo("c");
    }

}