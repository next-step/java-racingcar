package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowableOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("Cars 테스트")
class CarsTest {
    @DisplayName("null 또는 빈 리스트로 Cars 생성하려 하면 예외가 발생한다")
    @ParameterizedTest(name = "{0}")
    @NullAndEmptySource
    void exceptionShouldBeThrownForNullOrEmpty(final List<Car> nullOrEmpty) {
        // given & when
        final RuntimeException actual = catchThrowableOfType(() -> new Cars(nullOrEmpty), RuntimeException.class);

        // then
        assertThat(actual).hasMessage("자동차 목록이 비어있습니다");
    }

    @DisplayName("1 이상의 길이를 가진 리스트로 Cars를 생성할 수 있다")
    @Test
    void creationSuccessForMoreThanOneSizeOfCarList() {
        // given
        final List<Car> validCars = new ArrayList<>();
        final Car car = new Car();
        validCars.add(car);

        // when
        final Cars actual = new Cars(validCars);

        // then
        assertAll(
                () -> assertThat(actual).isNotNull(),
                () -> assertThat(actual.getCars()).hasSize(1)
        );
    }

    @DisplayName("tryAdvance 메서드를 통해 내부의 Car들에 대해 전진 시도할 수 있다 [전진 성공]")
    @Test
    void tryAdvanceForContainingCarsSuccessCase() {
        // given
        final Cars cars = new Cars(List.of(new Car(), new Car(), new Car()));
        final CarMoveGenerator mustMoveGenerator = () -> true;

        // when
        cars.tryAdvance(mustMoveGenerator);

        // then
        final List<Integer> actual = cars.getCars()
                .stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());

        assertThat(actual).containsExactly(2, 2, 2);
    }

    @DisplayName("tryAdvance 메서드를 통해 내부의 Car들에 대해 전진 시도할 수 있다 [전진 실패]")
    @Test
    void tryAdvanceForContainingCarsFailCase() {
        // given
        final Cars cars = new Cars(List.of(new Car(), new Car(), new Car()));
        final CarMoveGenerator mustMoveGenerator = () -> false;

        // when
        cars.tryAdvance(mustMoveGenerator);

        // then
        final List<Integer> actual = cars.getCars()
                .stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());

        assertThat(actual).containsExactly(1, 1, 1);
    }
}
