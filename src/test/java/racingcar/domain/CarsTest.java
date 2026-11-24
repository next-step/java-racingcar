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
    @DisplayName("차 이름이 중복되면 IllegalArgumentException")
    void throwsExceptionWhenNameIsDuplicated() {
        List<Car> duplicated = List.of(new Car("pobi"), new Car("crong"), new Car("pobi"));

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
        Cars cars = new Cars(List.of(new Car("pobi"), new Car("crong"), new Car("honux")));
        Iterator<Integer> numbers = List.of(4, 3, 9).iterator();

        cars.move(numbers::next);

        assertThat(cars.toResult().carResults()).extracting(CarResult::position).containsExactly(1, 0, 1);
    }

    @Test
    @DisplayName("현재 차들의 상태를 회차 결과로 반환한다")
    void toResult() {
        Cars cars = new Cars(List.of(new Car("pobi", 2), new Car("crong", 0)));

        assertThat(cars.toResult()).isEqualTo(new RoundResult(List.of(new CarResult(POBI, 2), new CarResult(CRONG, 0))));
    }
}
