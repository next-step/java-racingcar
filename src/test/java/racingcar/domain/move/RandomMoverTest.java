package racingcar.domain.move;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("FieldCanBeLocal")
@DisplayName("RandomMover 테스트")
class RandomMoverTest {

    @Nested
    @DisplayName("isMove 메소드는")
    class DescribeIsMoveMethod {

        @Nested
        @DisplayName("RandomMover가 0에서 3사이의 랜덤값이 생성되면,")
        class ContextReturn4 {

            private final Moveable randomMover = new RandomMover(0, 3);

            @Test
            @DisplayName("false를 반환한다.")
            void ItReturnFalse() {
                assertThat(randomMover.isMove()).isFalse();
            }

        }

        @Nested
        @DisplayName("RandomMover가 4에서 9사이의 랜덤값이 생성되면,")
        class ContextBinding3 {

            private final Moveable randomMover = new RandomMover(4, 9);

            @Test
            @DisplayName("true를 반환한다.")
            void ItReturnTrue() {
                assertThat(randomMover.isMove()).isTrue();
            }

        }

    }

}
