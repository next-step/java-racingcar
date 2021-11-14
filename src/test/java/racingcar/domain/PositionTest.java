package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class PositionTest {

    @DisplayName("위치는 0미만일 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -100, -1000})
    void verifyFalse(int value) {
        ThrowableAssert.ThrowingCallable callable = () -> Position.from(value);

        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(callable)
                .withMessageMatching("위치는 최소 0이상이어야 합니다.");
    }

    @DisplayName("움직이면 위치가 1증가한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2", "3,4", "0,1", "99,100"})
    void move(int value, int expect) {
        // given
        Position before = Position.from(value);

        // when
        Position after = before.move();

        // then
        Assertions.assertThat(after).isEqualTo(Position.from(expect));
    }
}
