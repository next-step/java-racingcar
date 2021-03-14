package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.FixedEngine;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @DisplayName("모두가 승리한다")
    @Test
    void allWinnerTest() {
        Car panda = new Car(new FixedEngine(4), "panda");
        Car pobi = new Car(new FixedEngine(4), "pobi");
        Car neo = new Car(new FixedEngine(4), "neo");
        Cars cars = new Cars(Arrays.asList(panda, pobi, neo));
        for (int i = 0; i < 5; i++) {
            cars.move();
        }
        assertThat(cars.getWinnerNames().size()).isEqualTo(3);
    }
}
