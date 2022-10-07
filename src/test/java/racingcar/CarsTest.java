package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.strategy.NumberGenerateStrategy;
import racingcar.strategy.RandomNumberGenerateStrategy;

class CarsTest {

    @Test
    @DisplayName("moveAll 메소드는 Cars가 갖고 있는 모든 자동차들을 모두 움직인다.")
    void moveAll_test() {
        List<String> carNames = List.of("jordy", "penda", "kero");
        Cars cars = new Cars(carNames, new NumberGenerateStrategy() {
            @Override
            public int generate() {
                return 5;
            }
        });
        cars.moveAll();

        assertThat(cars.allPosition()).containsOnly(1);
    }


    @Test
    @DisplayName("allPosition 메소드는 Cars가 갖고 있는 모든 자동차들의 position을 담은 리스트를 반환한다.")
    void allPosition_test() {
        List<String> carNames = List.of("jordy", "penda", "kero");
        NumberGenerateStrategy strategy = new RandomNumberGenerateStrategy(10);
        Cars cars = new Cars(carNames, strategy);

        assertThat(cars.allPosition()).hasSize(3);
    }
}