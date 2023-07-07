package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {
    @Test
    @DisplayName("자동차 이름 목록으로 여러 자동차를 생성한다.")
    void test_01() {
        /* given */
        final String value = "충환,정규,충규";

        /* when */
        final Cars cars = new Cars(value);

        /* then */
        assertThat(cars.getCars()).hasSize(3);
    }

    @Test
    @DisplayName("모든 자동차를 움직인다.")
    void test_02() {
        /* given */
        final Cars cars = new Cars("충환,정규,충규");

        /* when */
        cars.move(() -> 3);

        /* then */
        List<Car> movedCars = cars.getCars();

        assertThat(movedCars).containsExactly(new Car("충환", 3), new Car("정규", 3), new Car("충규", 3));
    }

    @Test
    @DisplayName("우승자를 구한다.")
    void test_03() {
        /* given */
        final Cars cars = new Cars(
                List.of(new Car("충환", 3),
                        new Car("정규", 3),
                        new Car("충규", 1)));

        /* when */
        final List<Car> winners = cars.winners();

        /* then */
        assertThat(winners).containsExactly(new Car("충환", 3), new Car("정규", 3));
    }

    @Test
    @DisplayName("우승자를 구할 수 없는 경우 IllegalStateException을 던진다.")
    void testThrowIllegalStateExceptionWhenWinnersIsNotBeCalculated() {
        /* given */
        final Cars cars = new Cars(Collections.emptyList());

        /* when & then */
        assertThatThrownBy(cars::winners).isInstanceOf(IllegalStateException.class);
    }
}
