package step5.client.worker.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static step5.client.worker.domain.CarName.ErrorMessage.CAR_NAME_LENGTH_MUST_BELOW_THEN_FIVE;
import static step5.client.worker.domain.CarName.ErrorMessage.CAR_NAME_MUST_NOT_BE_BLANK;

class CarNameTest {
    @DisplayName("of")
    @Nested
    class Of {
        @DisplayName("정상 생성")
        @Test
        void create() {
            // when
            final CarName carName = CarName.of("1");

            // then
            assertThat(carName).isNotNull();
        }

        @DisplayName("이름이 공백인 경우")
        @Test
        void throw_exception_when_receive_negative() {
            // when
            final Throwable thrown = catchThrowable(() -> {
                CarName.of("");
            });

            // then
            assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(CAR_NAME_MUST_NOT_BE_BLANK.getMessage());
        }

        @DisplayName("이름이 5글자를 초과한 경우")
        @Test
        void throw_exception_when_name_length_great_then_5() {
            // when
            final Throwable thrown = catchThrowable(() -> {
                CarName.of("123456");
            });

            // then
            assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(CAR_NAME_LENGTH_MUST_BELOW_THEN_FIVE.getMessage());
        }
    }
}