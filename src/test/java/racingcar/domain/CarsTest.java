package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class CarsTest {

    private final Cars cars = Cars.of(new Car("A"), new Car("B"));

    @ParameterizedTest
    @DisplayName("랜덤 값이 4이상인 경우 자동차는 전진한다.")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void go_forward_car_value_more_than_4(int randomValue) {
        cars.move(new ManualValueGenerator(randomValue));
        for (Car car : cars.getCars()) {
            assertThat(car.getLocation()).isEqualTo(new Location(1));
        }
    }

    @ParameterizedTest
    @DisplayName("랜덤 값이 4보다 작은 경우 자동차는 멈춘다.")
    @ValueSource(ints = {0, 1, 2, 3})
    void stop_car_value_smaller_than_4(int randomValue) {
        cars.move(new ManualValueGenerator(randomValue));
        for (Car car : cars.getCars()) {
            assertThat(car.getLocation()).isEqualTo(new Location(0));
        }
    }

    @Test
    @DisplayName("자동차 개수는 한대 이상이다.")
    void create_with_count_over_minimum() {
        assertThatNoException().isThrownBy(() -> Cars.create("one"));
    }

    @ParameterizedTest
    @DisplayName("자동차 이름이 1개보다 작으면 에러가 발생한다.")
    @NullSource
    @EmptySource
    void create_with_null_or_empty_name(String names) {
        assertThatThrownBy(() -> Cars.create(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름을 입력해주세요.");
    }

    @Test
    @DisplayName("자동차 이름 개수 만큼 자동차를 생성한다.")
    void create_cars_with_name_count() {
        assertThat(Cars.create("a,b,c").getCars()).hasSize(3);
    }

    @Test
    @DisplayName("자동차 경주 우승자를 구한다.")
    void find_one_winner() {
        Cars endCars = Cars.of(
                new Car("A", 1),
                new Car("B", 0)
        );
        assertThat(endCars.findWinners()).contains(new Name("A"));
    }

    @Test
    @DisplayName("자동차 경주 우승자는 여러명일 수 있다.")
    void find_several_winner() {
        Cars endCars = Cars.of(
                new Car("A", 1),
                new Car("B", 1)
        );
        assertThat(endCars.findWinners()).contains(new Name("A"), new Name("B"));
    }
}