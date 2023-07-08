package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.move.Moveable;

import static org.assertj.core.api.Assertions.*;

@SuppressWarnings("FieldCanBeLocal")
@DisplayName("Car 클래스")
class CarTest {

    @Nested
    @DisplayName("new 생성자는")
    class DescribeNewConstructor {

        private final Moveable trueMover = () -> true;

        @Nested
        @DisplayName("1~5자 사이의 이름이 주어진다면,")
        class ContextNormalInput {

            private final String minimumInput = "1";
            private final String fullInput = "12345";

            @Test
            @DisplayName("생성이 완료 한다.")
            void ItCreated() {
                assertThatNoException().isThrownBy(() -> new Car(minimumInput, trueMover));
                assertThatNoException().isThrownBy(() -> new Car(fullInput, trueMover));
            }

        }

        @Nested
        @DisplayName("0자 또는 6자 이상의 이름이 주어진다면,")
        class ContextInvalidInput {

            private final String blankInput = "";
            private final String overflowInput = "123456";

            @Test
            @DisplayName("IllegalArgumentException 이 발생한다.")
            void ItThrowIllegalArgumentException() {
                assertThatThrownBy(() -> new Car(blankInput, trueMover)).isInstanceOf(IllegalArgumentException.class);
                assertThatThrownBy(() -> new Car(overflowInput, trueMover)).isInstanceOf(IllegalArgumentException.class);
            }

        }

        @Nested
        @DisplayName("null값이 이름으로 주어진다면,")
        class ContextNullInput {

            private final String nullInput = null;

            @Test
            @DisplayName("IllegalArgumentException 이 발생한다.")
            void ItThrowIllegalArgumentException() {
                assertThatThrownBy(() -> new Car(nullInput, trueMover)).isInstanceOf(IllegalArgumentException.class);
            }

        }

        @Nested
        @DisplayName("null값이 Moveable으로 주어진다면,")
        class ContextMoveableNullInput {

            private final String normalInput = "123";
            private final Moveable nullMoveable = null;

            @Test
            @DisplayName("IllegalArgumentException 이 발생한다.")
            void ItThrowIllegalArgumentException() {
                assertThatThrownBy(() -> new Car(normalInput, nullMoveable))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("Moveable은 null값이 될 수 없습니다.");
            }

        }

    }

    @Nested
    @DisplayName("move 메소드는")
    class DescribeMoveMethod {

        private final String normalInput = "123";

        @Nested
        @DisplayName("Moveable이 true로 바인딩 되어 있다면,")
        class ContextTrueMover {

            private final Moveable trueMover = () -> true;
            private final Car car = new Car(normalInput, trueMover);

            @Test
            @DisplayName("position이 1 증가된 값을 반환한다.")
            void ItReturnIncreasedPosition() {
                int position = car.getPosition();

                car.move();

                assertThat(car.getPosition()).isEqualTo(position + 1);
            }

        }

        @Nested
        @DisplayName("Moveable이 false로 바인딩 되어 있다면,")
        class ContextFalseMover {

            private final Moveable falseMover = () -> false;
            private final Car car = new Car(normalInput, falseMover);

            @Test
            @DisplayName("position이 증가하지 않는다.")
            void ItReturnIncreasedPosition() {
                int position = car.getPosition();

                car.move();

                assertThat(car.getPosition()).isEqualTo(position);
            }

        }
    }

}
