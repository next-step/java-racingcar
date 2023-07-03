package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@SuppressWarnings("FieldCanBeLocal")
@DisplayName("Car 클래스")
class CarTest {

    @Nested
    @DisplayName("new 생성자는")
    class ContextNewConstructor {

        @Nested
        @DisplayName("1~5자 사이의 이름이 주어진다면,")
        class DescribeNormalInput {

            private final String minimumInput = "1";
            private final String fullInput = "12345";

            @Test
            @DisplayName("생성이 완료 한다.")
            void ItCreated() {
                assertThatNoException().isThrownBy(() -> new Car(minimumInput));
                assertThatNoException().isThrownBy(() -> new Car(fullInput));
            }

        }

        @Nested
        @DisplayName("0자 또는 6자 이상의 이름이 주어진다면,")
        class DescribeInvalidInput {

            private final String blankInput = "";
            private final String overflowInput = "123456";

            @Test
            @DisplayName("IllegalArgumentException 이 발생한다.")
            void ItThrowIllegalArgumentException() {
                assertThatThrownBy(() -> new Car(blankInput)).isInstanceOf(IllegalArgumentException.class);
                assertThatThrownBy(() -> new Car(overflowInput)).isInstanceOf(IllegalArgumentException.class);
            }

        }

    }

}
