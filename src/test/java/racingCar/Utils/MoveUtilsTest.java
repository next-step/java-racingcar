package racingCar.Utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingCar.Entity.RacingCar;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MoveUtilsTest {

    @ParameterizedTest
    @MethodSource("provideData")
    @DisplayName("Car Position이 제대로 변경 되는지")
    void setPosition(RacingCar a, int b, int expected) {
        MoveUtils.setPosition(a, b);
        int result = a.getPosition();
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new RacingCar(0), 5, 1),
                Arguments.of(new RacingCar(3), 1, 3),
                Arguments.of(new RacingCar(2), 9, 3)
        );
    }
}
