package race.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.ArgumentUtils;

class PositionTest {

    @ParameterizedTest
    @MethodSource("providePositionsAndBoolean")
    void isEqual_테스트(int number1, int number2, boolean expected) {
        // Given
        Position position1 = Position.createInstance(number1);
        Position position2 = Position.createInstance(number2);

        // When & Then
        assertThat(position1.isEqual(position2)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("providePositionAndNumber")
    void compareTo_테스트(int number1, int number2, int result) {
        // Given
        Position position1 = Position.createInstance(number1);
        Position position2 = Position.createInstance(number2);

        // When & Then
        assertThat(position1.compareTo(position2)).isEqualTo(result);
    }

    private static Stream<Arguments> providePositionsAndBoolean() {
        return Stream.of(
                Arguments.of(4,3, false),
                Arguments.of(4,4, true)
        );
    }

    private static Stream<Arguments> providePositionAndNumber() {
        return Stream.of(
                Arguments.of(4,3, 1),
                Arguments.of(4,4, 0),
                Arguments.of(3,4, -1)
        );
    }
}