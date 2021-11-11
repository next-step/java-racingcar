package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @ParameterizedTest
    @DisplayName("Position 생성 성공 테스트")
    @MethodSource
    void createPosition(int value, Position expected) {
        assertThat(Position.from(value)).isEqualTo(expected);
    }

    static Stream<Arguments> createPosition() {
        return Stream.of(
                Arguments.of(
                        1, Position.from(1)
                ),
                Arguments.of(
                        2, Position.from(2)
                ),
                Arguments.of(
                        2, Position.from(2)
                )
        );
    }
}