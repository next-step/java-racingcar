package step5.client.worker.domain;

import common.util.Preconditions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static step5.client.worker.domain.Position.ErrorMessage.POSITION_VALUE_MUST_MORE_THEN_ZERO;

class PositionTest {

    @DisplayName("of")
    @Nested
    class Of {
        @DisplayName("정상 생성")
        @Test
        void create() {
            // when
            final Position position = Position.of(0);

            // then
            assertThat(position).isNotNull();
        }

        @DisplayName("position 값이 음수인 경우 예외 throw")
        @Test
        void throw_exception_when_receive_negative() {
            // when
            final Throwable thrown = catchThrowable(() -> {
                Position.of(-1);
            });

            // then
            assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(POSITION_VALUE_MUST_MORE_THEN_ZERO.getMessage());
        }
    }
    
    @Test
    void increase() {
        // given
        final Position position = Position.of(0);
        
        // when
        position.increase(1);
        
        // then
        assertThat(position).isEqualTo(Position.of(1));
    }

}