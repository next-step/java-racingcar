package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.support.TestNumberGenerator;

import static org.assertj.core.api.Assertions.*;

class CarsTest {

    @DisplayName("자동차들 생성")
    @Test
    void test01() {
        Cars cars = new Cars(3);

        assertThat(cars).isNotNull();
    }

    @DisplayName("자동차 경주 시작 시 전진한다.")
    @Test
    void test02() {
        Cars cars = new Cars(3);

        cars.race(new TestNumberGenerator(4));

        assertThat(cars.position()).containsExactly(1, 1, 1);
    }

    @DisplayName("자동차 경주 시작 시 멈춰 있는다.")
    @Test
    void test03() {
        Cars cars = new Cars(3);

        cars.race(new TestNumberGenerator(3));

        assertThat(cars.position()).containsExactly(0, 0, 0);
    }
}