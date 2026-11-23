package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarsTest {
    private static final CarName POBI = new CarName("pobi");
    private static final CarName CRONG = new CarName("crong");
    private static final CarName HONUX = new CarName("honux");

    @Test
    @DisplayName("가장 멀리 간 차가 우승한다")
    void singleWinner() {
        Cars cars = new Cars(List.of(new Car(POBI, 3), new Car(CRONG, 1), new Car(HONUX, 2)));

        assertThat(cars.getWinners()).containsExactly(POBI);
    }

    @Test
    @DisplayName("가장 멀리 간 차가 여럿이면 모두 우승한다")
    void multipleWinners() {
        Cars cars = new Cars(List.of(new Car(POBI, 3), new Car(CRONG, 1), new Car(HONUX, 3)));

        assertThat(cars.getWinners()).containsExactly(POBI, HONUX);
    }

    @Test
    @DisplayName("차 이름이 중복되면 IllegalArgumentException")
    void throwsExceptionWhenNameIsDuplicated() {
        List<Car> duplicated = List.of(new Car(POBI), new Car(CRONG), new Car(new CarName("pobi")));

        assertThatIllegalArgumentException().isThrownBy(() -> new Cars(duplicated))
                .withMessage("duplicate name is not allowed [pobi]");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("차 목록이 null이거나 비어 있으면 IllegalArgumentException")
    void throwsExceptionWhenCarsAreEmpty(List<Car> cars) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Cars(cars))
                .withMessage("at least one car is required");
    }

    @Test
    @DisplayName("생성된 숫자에 따라 각 차가 움직인다")
    void move() {
        Cars cars = new Cars(List.of(new Car(POBI), new Car(CRONG), new Car(HONUX)));
        Iterator<Integer> numbers = List.of(4, 3, 9).iterator();

        cars.move(numbers::next);

        assertThat(cars.getCars()).extracting(Car::getPosition).containsExactly(1, 0, 1);
    }
}
