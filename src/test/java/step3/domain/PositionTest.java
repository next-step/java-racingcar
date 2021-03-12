package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * 원시 타입 자료형을 관리하는 클래스 테스트
 */
class PositionTest {

    private static Stream<Arguments> movePositionTestCase() {
        return Stream.of(
                Arguments.of(0, new Position(3)),
                Arguments.of(2, new Position(5))
        );
    }

    private static Stream<Arguments> greaterThanEntry() {
        return Stream.of(
                Arguments.of(new Position(3), new Position(1), new Position(3)),
                Arguments.of(new Position(5), new Position(4), new Position(5))
        );
    }

    @DisplayName("Position 객체 비교 테스트")
    @Test
    void equalsPositionTest() {
        Position position = new Position(3);
        assertThat(position).isEqualTo(new Position(3));
    }

    @ParameterizedTest(name = "Position 이동 확인 테스트")
    @MethodSource(value = "movePositionTestCase")
    void movePositionTest(final int initPosition, final Position maxPosition) {
        Position position = new Position(initPosition);

        position = position.move();
        position = position.move();
        position = position.move();

        assertThat(position).isEqualTo(maxPosition);
    }

    @ParameterizedTest(name = "position 예외 테스트")
    @CsvSource(value = {"-1", "-2"})
    void exceptionPositionTest(final int given) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Position(given));
    }

    @DisplayName(value = "greaterThan() 테스트")
    @ParameterizedTest(name = "Position 비교 메서드 테스트")
    @MethodSource(value = "greaterThanEntry")
    void greaterThanPositionTest(Position left, Position right, Position expected) {
        // when
        Position result = left.greaterThan(right);
        // then
        assertThat(result).isEqualTo(expected);
    }
}
