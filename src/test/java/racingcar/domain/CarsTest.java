package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.generator.ManualValueGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarsTest {

    private final Cars cars = createCars(new Car("A"), new Car("B"));

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
    @DisplayName("자동차 위치 중 가장 멀리있는 위치를 구한다.")
    void find_max_location() {
        Cars cars = createCars(
                createCar("A", 1),
                createCar("B", 2)
        );
        assertThat(cars.findMaxLocation()).isEqualTo(new Location(2));
    }

    @Test
    @DisplayName("같은 위치에 있는 자동차 이름을 반환한다.")
    void find_same_location_cars() {
        assertThat(createCars(
                createCar("A", 1),
                createCar("B", 1)
        ).findSameLocationCarNames(new Location(1))).contains(new Name("A"), new Name("B"));
    }


    private Car createCar(String name, int location) {
        return new Car(new Name(name), new Location(location));
    }

    private Cars createCars(Car... cars) {
        return new Cars(List.of(cars));
    }
}