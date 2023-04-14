package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarsTest {

    @Test
    void 자동차_참가자목록_반환() {
        List<Car> cars = Cars.registerCars(Arrays.asList("1","2","3","4","5"));
        List<String> names = cars.stream().map(Car::name).collect(Collectors.toList());
        assertAll(
            () -> assertThat(cars).hasSize(5),
            () -> assertThat(cars).doesNotContainNull(),
            () -> assertThat(names).doesNotContain(Car.DEFAULT_NAME)
        );
    }

    @Test
    void 자동차_멤버변수_값_변경불가() {
        Car origin = new Car();
        List<Car> carList = new ArrayList<>();
        carList.add(origin);
        Cars cars = new Cars(carList);

        List<Car> result = cars.cars();
        result.get(0).move();
        assertAll(
            () -> assertThatExceptionOfType(UnsupportedOperationException.class)
                .isThrownBy(() -> result.add(new Car())),
            () -> assertThat(origin.position()).isEqualTo(Car.SET_POSITION),
            () -> assertThat(result.get(0)).isNotSameAs(origin)
        );
    }

    @Test
    void 자동차_클론() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car());
        Cars cars = new Cars(carList);

        Cars clone = cars.clone();
        assertAll(
            () -> assertThat(clone).isNotSameAs(cars),
            () -> assertThat(clone.cars().size()).isEqualTo(cars.cars().size())
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 자동차_이동기준값이상입력(int number) {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car());
        Cars cars = new Cars(carList);

        cars.raceLap(new RandomRacingRule().movableList(Arrays.asList(number)));
        assertThat(cars.cars().get(0).position()).isEqualTo(Car.SET_POSITION + 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void 자동차_이동기준값미만입력(int number) {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car());
        Cars cars = new Cars(carList);

        cars.raceLap(new RandomRacingRule().movableList(Arrays.asList(number)));
        assertThat(cars.cars().get(0).position()).isEqualTo(Car.SET_POSITION);
    }

    @Test
    void 자동차_초기화() {
        List<Car> carList = new ArrayList<>();
        int len = 5;
        for (int i = 0; i < len; i++) {
            carList.add(new Car());
        }

        Cars cars = new Cars(carList);
        assertThat(cars.cars()).hasSize(len);
    }

}
