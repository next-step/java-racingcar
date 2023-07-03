package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

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
                assertThat(new Car(minimumInput)).assertThatNoException();
                assertThat(new Car(fullInput)).assertThatNoException();
            }

        }

    }

}
