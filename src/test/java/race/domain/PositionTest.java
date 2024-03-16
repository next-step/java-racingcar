package race.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PositionTest {

    @ParameterizedTest
    @MethodSource("providePositionsAndBoolean")
    void isEqual_테스트(int number1, int number2, boolean expected) {
        // Given
        Position position1 = Position.createInstance(number1);
        Position position2 = Position.createInstance(number2);

        // When & Then
        assertThat(position1.isEqual(position2.getValue())).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("providePositionsAndMax")
    void max_테스트(int number1, int number2, int max) {
        // Given
        Position position1 = Position.createInstance(number1);
        Position position2 = Position.createInstance(number2);

        // When & Then
        assertThat(position1.max(position2.getValue())).isEqualTo(max);
    }

    private static Stream<Arguments> providePositionsAndMax() {
        return Stream.of(
                Arguments.of(4,3, 4),
                Arguments.of(4,4, 4),
                Arguments.of(1,4, 4)
        );
    }

    private static Stream<Arguments> providePositionsAndBoolean() {
        return Stream.of(
                Arguments.of(4,3, false),
                Arguments.of(4,4, true)
        );
    }
}