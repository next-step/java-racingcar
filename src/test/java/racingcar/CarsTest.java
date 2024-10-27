package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    private Cars cars;

    @Test
    @DisplayName("입력한 수 만큼의 자동차를 생성한다.")
    void 자동차_생성() {
        cars = Cars.fromCarNames(Arrays.asList("name", "name2", "name3"));
        assertThat(cars.getValues()).hasSize(3);
    }

    @Test
    @DisplayName("입력한 수만큼 라운드를 진행하고, 자동차 수만큼 결과값을 기록한다.")
    void 경기_진행() {
        Cars cars = Cars.fromCarNames(Arrays.asList("name", "name2", "name3"));
        assertThat(cars.runRace(5)).hasSize(5);
        assertThat(cars.runRace(5).get(0)).hasSize(3);
    }

    @Test
    @DisplayName("자동차 중 1명 이상의 우승자를 구한다.")
    void 우승자_구하기() {
        cars = new Cars(new Car("name1", 3, () -> false), new Car("name2", 8, () -> false), new Car("name3", 8, () -> false));

        assertThat(cars.getWinners()).hasSize(2);
        assertThat(cars.getWinners()).containsAll(Arrays.asList("name2", "name3"));
    }
}
