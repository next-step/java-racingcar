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

        assertThat(cars.getPositions()).containsOnly(1);
    }


    @Test
    @DisplayName("getPositions 메소드는 Cars가 갖고 있는 모든 자동차들의 position을 담은 리스트를 반환한다.")
    void getPositions_test() {
        List<String> carNames = List.of("jordy", "penda", "kero");
        NumberGenerateStrategy strategy = new RandomNumberGenerateStrategy();
        Racers cars = new Racers(carNames, strategy);

        assertThat(cars.getPositions()).hasSize(3);
    }

    @Test
    @DisplayName("getMaxPosition 메소드는 Cars가 갖고 있는 모든 자동차들의 position 중 최대 값을 반환한다.")
    void getMaxPosition_test() {
        List<String> carNames = List.of("jordy", "penda", "kero");
        Racers cars = new Racers(carNames, new SameNumberGenerateStrategy());
        cars.moveAll();

        assertThat(cars.getMaxPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("findSamePositionCars 메소드는 주어진 위치와 같은 위치 값을 가진 자동차 이름 리스트를 반환한다.")
    void findSamePositionCars() {
        List<String> carNames = List.of("jordy", "penda", "kero");
        Racers cars = new Racers(carNames, new SameNumberGenerateStrategy());
        cars.moveAll();

        assertThat(cars.findSamePositionCars(1)).containsExactly("jordy", "penda", "kero");
    }
}