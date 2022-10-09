package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.strategy.NumberGenerateStrategy;
import racingcar.strategy.RandomNumberGenerateStrategy;

class CarsTest {

    @Test
    @DisplayName("moveAll 메소드는 Cars가 갖고 있는 모든 자동차들을 모두 움직인다.")
    void moveAll_test() {
        List<String> carNames = List.of("jordy", "penda", "kero");
        Racers cars = new Racers(carNames, new SameNumberGenerateStrategy());
        cars.moveAll();

        assertThat(cars.positions()).containsOnly(1);
    }


    @Test
    @DisplayName("allPosition 메소드는 Cars가 갖고 있는 모든 자동차들의 position을 담은 리스트를 반환한다.")
    void allPosition_test() {
        List<String> carNames = List.of("jordy", "penda", "kero");
        NumberGenerateStrategy strategy = new RandomNumberGenerateStrategy();
        Racers cars = new Racers(carNames, strategy);

        assertThat(cars.positions()).hasSize(3);
    }

    @Test
    @DisplayName("maxPosition 메소드는 Cars가 갖고 있는 모든 자동차들의 position 중 최대 값을 반환한다.")
    void maxPosition_test() {
        List<String> carNames = List.of("jordy", "penda", "kero");
        Racers cars = new Racers(carNames, new SameNumberGenerateStrategy());
        cars.moveAll();

        assertThat(cars.maxPosition()).isEqualTo(1);
    }
}