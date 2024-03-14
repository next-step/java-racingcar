package step3.application.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CarTest {


    public static Stream<Arguments> move() {
        return Stream.of(
                arguments(new Car(0), List.of(false, false, false), 0),
                arguments(new Car(1), List.of(true, false, false), 1),
                arguments(new Car(2), List.of(true, true, false), 2),
                arguments(new Car(3), List.of(true, true, true), 3)
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("움직임 여부에 따라 현재 위치를 유지하거나 변경한다.")
    void move(Car car, List<Boolean> movables, int expectedPosition) {
        movables.forEach(car::move);
        int currentLocation = car.verifyLocation();
        assertThat(currentLocation).isEqualTo(expectedPosition);
    }
}