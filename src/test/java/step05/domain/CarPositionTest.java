package step05.domain;

import exception.NotPositiveIntegerException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarPositionTest {

    private static Stream<Arguments> provideMovableResult() {
        return Stream.of(
                Arguments.of(1, true, 2),
                Arguments.of(1, false, 1),
                Arguments.of(4, true, 5)
        );
    }

    @DisplayName("자동차의 위치가 바뀌었는지 검사")
    @ParameterizedTest
    @MethodSource("provideMovableResult")
    public void test_move(int position, boolean movable, int expect) {
        CarPosition carPosition = CarPosition.of(position);
        assertThat(carPosition.move(() -> movable)).isEqualTo(CarPosition.of(expect));
    }

    private static Stream<Arguments> provideNotPositiveIntegerResult() {
        return Stream.of(
                Arguments.of(-1),
                Arguments.of(0)
        );
    }

    @DisplayName("CarPosition 의 초기화 값이 양수가 아니면 에러던짐")
    @ParameterizedTest
    @MethodSource("provideNotPositiveIntegerResult")
    public void isPositiveInteger_NotPositiveInteger_throwException(int NotPositiveInteger) {
        assertThatExceptionOfType(NotPositiveIntegerException.class)
                .isThrownBy(() -> CarPosition.of(NotPositiveInteger));
    }

    @DisplayName("CarPosition 객체 반환")
    @Test
    public void test_getCarPosition() {
        CarPosition carPosition = CarPosition.of(1);
        assertThat(carPosition.getCarPosition()).isEqualTo(CarPosition.of(1));
    }

}
