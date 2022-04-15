package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.data.MapEntry.entry;

class CarsTest {
    private static final String POBI = "pobi";
    private static final String CRONG = "crong";
    private static final String HONUX = "honux";
    private static final int ZERO = 0;
    private static final int FIVE = 5;
    private static final int TEN = 10;

    @DisplayName("중복 이름이 있으면 예외")
    @Test
    void validation() {
        List<Car> duplicateCars = List.of(new Car(POBI), new Car(POBI));

        assertThatThrownBy(() -> new Cars(duplicateCars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getCurrentPositions() {
        List<Car> carList = List.of(new Car(POBI, ZERO), new Car(CRONG, FIVE), new Car(HONUX, TEN));
        Cars cars = new Cars(carList);

        Map<CarName, Position> currentPositions = cars.getCurrentPositions();

        assertThat(currentPositions).containsOnly(
                entry(new CarName(POBI), new Position(ZERO)),
                entry(new CarName(CRONG), new Position(FIVE)),
                entry(new CarName(HONUX), new Position(TEN))
        );
    }

    @Test
    void getMostDistantCars() {
        List<Car> carList = List.of(new Car(POBI, ZERO), new Car(CRONG, TEN), new Car(HONUX, TEN));
        Cars cars = new Cars(carList);

        List<Car> mostDistantCars = cars.getMostDistantCars();

        assertThat(mostDistantCars).containsExactly(new Car(CRONG, TEN), new Car(HONUX, TEN));
    }
}