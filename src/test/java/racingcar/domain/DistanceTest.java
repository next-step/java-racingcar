package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class DistanceTest {
    @DisplayName("주행거리가 같으면 주행거리 객체는 같다.")
    @ParameterizedTest
    @MethodSource("distance")
    void equals(Distance distance, Distance other, boolean expected) {
        assertThat(distance.equals(other)).isEqualTo(expected);
    }

    @DisplayName("주행거리를 증가시키면 주행거리는 1씩 증가한다.")
    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 3 })
    void increment(int distance) {
        assertThat(new Distance(distance).increment()).isEqualTo(new Distance(distance + 1));
    }

    private static Stream<Arguments> distance() {
        return Stream.of(
                Arguments.arguments(Distance.ZERO, null, false),
                Arguments.arguments(Distance.ZERO, new Distance(0), true),
                Arguments.arguments(new Distance(3), new Distance(1), false),
                Arguments.arguments(new Distance(4), new Distance(4), true)
        );
    }
}
