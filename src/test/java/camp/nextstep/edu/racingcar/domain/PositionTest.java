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

    @DisplayName("max 메서드가 잘 동작하는지 - a 가 큰 경우")
    @Test
    void maxWhenAIsGreaterThanB() {
        // given
        final Position one = Position.origin().add(1);
        final Position two = Position.origin().add(2);
        // when
        final Position result = Position.max(one, two);
        // then
        assertThat(result).isEqualTo(two);
    }

    @DisplayName("max 메서드가 잘 동작하는지 - b 가 큰 경우")
    @Test
    void maxWhenAIsLessThanB() {
        // given
        final Position one = Position.origin().add(1);
        final Position two = Position.origin().add(2);
        // when
        final Position result = Position.max(two, one);
        // then
        assertThat(result).isEqualTo(two);
    }

    @DisplayName("max 메서드가 잘 동작하는지 - a, b 가 같은 경우")
    @Test
    void maxWhenAIsEqualToB() {
        // given
        final Position one = Position.origin().add(1);
        // when
        final Position result = Position.max(one, one);
        // then
        assertThat(result).isEqualTo(one);
    }

    @DisplayName("두 패러미터 중에 하나라도 null 이면 IllegalArgumentException 발생해야함")
    @Test
    void maxShouldThrowsIllegalArgumentExceptionWhenGivenArgumentIsNull() {
        // given
        final Position notNullPosition = Position.origin().add(1);

        assertThatIllegalArgumentException()
                // when 1
                .isThrownBy(() -> Position.max(null, notNullPosition))
                // then 1
                .withMessageContaining("must not be null");

        assertThatIllegalArgumentException()
                // when 2
                .isThrownBy(() -> Position.max(notNullPosition, null))
                // then 2
                .withMessageContaining("must not be null");
    }
}