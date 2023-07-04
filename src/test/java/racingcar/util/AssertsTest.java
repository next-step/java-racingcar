package racingcar.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@SuppressWarnings("FieldCanBeLocal")
@DisplayName("Asserts 클래스")
class AssertsTest {

    @Nested
    @DisplayName("notNull 메소드는")
    class DescribeNotNull {

        @Nested
        @DisplayName("null 값이 들어오면,")
        class ContextNullInput {

            private final Object nullInput = null;

            @Test
            @DisplayName("IllegalArgumentException을 던진다.")
            void throwIllegalArgumentException() {
                Assertions.assertThatThrownBy(() -> Asserts.notNull(nullInput, () -> "null 값이 들어올 수 없습니다."))
                    .isInstanceOf(IllegalArgumentException.class);
            }

        }

    }

}
