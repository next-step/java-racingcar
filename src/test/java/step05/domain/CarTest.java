package step05.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private static Stream<Arguments> provideMovableResult() {
        return Stream.of(
          Arguments.of(1, true, 2),
          Arguments.of(1, false, 1)
        );
    }

    @DisplayName("Car 를 move 메서드 호출")
    @ParameterizedTest
    @MethodSource("provideMovableResult")
    public void test_move(int position, boolean movable, int expect) {
        Car car = Car.of("name", position);
        assertThat(car.move(() -> movable)).isEqualToComparingOnlyGivenFields(Car.of("name", expect));
    }
}
