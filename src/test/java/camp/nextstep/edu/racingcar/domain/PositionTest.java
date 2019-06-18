package camp.nextstep.edu.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PositionTest {
    @DisplayName("객체가 잘 생성되는지")
    @Test
    void constructor() {
        final Position position = Position.origin();
        assertThat(position).isNotNull();
        assertThat(position.value()).isEqualTo(0);
    }

    @DisplayName("add 메서드를 호출하면, 현재 값보다 distance 만큼 더해진 새 Position 객체가 생성되어야함")
    @Test
    void add() {
        // given
        final Position position = Position.origin();
        // when
        final Position result = position.add(2);
        // then
        assertThat(result).isNotNull();
        assertThat(result.value()).isEqualTo(2);
    }

    @DisplayName("add 메서드를 호출해도, 원본 객체는 값을 그대로 유지해야함")
    @Test
    void addButOriginalObjectShouldBeImmutable() {
        // given
        final Position position = Position.origin();
        // when
        final Position result = position.add(2);
        // then
        assertThat(result.value()).isEqualTo(2);
        assertThat(position.value()).isEqualTo(0);
    }

    @DisplayName("add 의 결과가 음수 좌표값을 가지게 되면, IllegalArgumentException 을 발생시켜야함")
    @Test
    void addThrowsIllegalArgumentExceptionWhenResultPositionHasValueLessThenZero() {
        // given
        final Position position = Position.origin();
        // when
        assertThatIllegalArgumentException()
                .isThrownBy(() -> position.add(-2))
                // then 1
                .withMessageContaining("must be greater than or equal to");
        // then 2
        assertThat(position.value()).isEqualTo(0);
    }
}