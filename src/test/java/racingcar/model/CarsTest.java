package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Cars;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    @DisplayName("주어진 개수만큼 자동차 객체가 생성되어야한다.")
    @Test
    void countCars() {
        Cars cars = new Cars(3);
        assertThat(cars.countCars()).isEqualTo(3);
    }

    @DisplayName("시도 후 점수가 달라져야한다.")
    @Test
    void getScores() {
        Cars cars = new Cars(3);
        List<Integer> before = cars.getScores();
        for (int i = 0; i < 5; i++) {
            cars.attempt();
        }
        List<Integer> after = cars.getScores();
        assertThat(after).isNotEqualTo(before);
    }
}
