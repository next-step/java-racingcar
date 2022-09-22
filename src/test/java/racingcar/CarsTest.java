package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("자동차 경주 리스트를 초기화한다")
    @Test
    void initialize() {
        Cars cars = Cars.of(List.of("name1", "name2", "name3"));

        assertThat(cars.cars().size()).isEqualTo(3);
        assertThat(cars.cars().get(0).currentPosition()).isEqualTo(0);
    }

    @DisplayName("다음 자동차 경주 리스트를 반환한다")
    @Test
    void next() {
        Cars cars = Cars.of(List.of("name1", "name2", "name3"));

        Cars nextCars = cars.next();

        assertThat(nextCars.cars()).hasSize(3);
    }

    @DisplayName("자동차 중 가장 많이 이동한 차들을 구한다")
    @Test
    void winners() {
        Cars cars = new Cars(List.of(
                Car.of(0, "name1"),
                Car.of(2, "name2"),
                Car.of(5, "name3"),
                Car.of(5, "name4")));

        assertThat(cars.winners()).isEqualTo(List.of(
                Car.of(5, "name3"),
                Car.of(5, "name4")));
    }
}