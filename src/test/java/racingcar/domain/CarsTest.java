package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.support.TestNumberGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarsTest {

    @DisplayName("자동차들 생성")
    @Test
    void test01() {
        Cars cars = new Cars(List.of("car1", "car2", "car3"));

        assertThat(cars).isNotNull();
    }

    @DisplayName("자동차 경주 시작 시 전진한다.")
    @Test
    void test02() {
        Cars cars = new Cars(List.of("car1", "car2", "car3"));

        cars.race(new TestNumberGenerator(4));

        assertThat(cars.positions()).isEqualTo(getPositions(1));
    }

    @DisplayName("자동차 경주 시작 시 멈춰 있는다.")
    @Test
    void test03() {
        Cars cars = new Cars(List.of("car1", "car2", "car3"));

        cars.race(new TestNumberGenerator(3));

        assertThat(cars.positions()).isEqualTo(getPositions(0));
    }

    @DisplayName("Positions 를 가져온다.")
    @Test
    void test04() {
        Cars cars = new Cars(getCar("a", 1), getCar("b", 2));

        assertThat(cars.positions()).hasSize(2)
                .containsExactly(new Position(1), new Position(2));
    }

    @DisplayName("가장 높은 Position 을 가져온다.")
    @Test
    void test05() {
        Cars cars = new Cars(getCar("a", 1), getCar("b", 2));

        assertThat(cars.highPosition()).isEqualTo(new Position(2));
    }

    private static Car getCar(String name, int position) {
        return new Car(name, new Position(position));
    }

    private List<Position> getPositions(int position) {
        return List.of(new Position(position), new Position(position), new Position(position));
    }
}
