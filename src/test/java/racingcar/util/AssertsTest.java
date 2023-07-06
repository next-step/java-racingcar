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

        @Nested
        @DisplayName("null이 아닌 값이 들어오면,")
        class ContextNotNullInput {

            private final Object notNullInput = new Object();

            @Test
            @DisplayName("예외를 던지지 않는다.")
            void notThrowException() {
                Assertions.assertThatNoException()
                    .isThrownBy(() -> Asserts.notNull(notNullInput, () -> "null 값이 들어올 수 없습니다."));
            }

        }

    }

    @Nested
    @DisplayName("isTrue 메소드는")
    class DescribeIsTrue {

        @Nested
        @DisplayName("true값이 들어오면")
        class ContextTrueInput {

            private final boolean trueInput = true;

            @Test
            @DisplayName("예외를 던지지 않는다.")
            void notThrowException() {
                Assertions.assertThatNoException()
                    .isThrownBy(() -> Asserts.isTrue(trueInput, () -> "true input"));
            }

        }

        @Nested
        @DisplayName("false값이 들어오면")
        class ContextFalseInput {

            private final boolean falseInput = false;

            @Test
            @DisplayName("IllegalArgumentException을 던진다.")
            void throwIllegalArgumentException() {
                Assertions.assertThatThrownBy(() -> Asserts.isTrue(falseInput, () -> "false값이 들어올 수 없습니다."))
                    .isInstanceOf(IllegalArgumentException.class);
            }

        }

    }

    @Nested
    @DisplayName("isFalse 메소드는")
    class DescribeIsFalse {

        @Nested
        @DisplayName("false값이 들어오면")
        class ContextFalseInput {

            private final boolean falseInput = false;

            @Test
            @DisplayName("예외를 던지지 않는다.")
            void notThrowException() {
                Assertions.assertThatNoException()
                    .isThrownBy(() -> Asserts.isFalse(falseInput, () -> "true input"));
            }

        }

        @Nested
        @DisplayName("true값이 들어오면")
        class ContextTrueInput {

            private final boolean trueInput = true;

            @Test
            @DisplayName("IllegalArgumentException을 던진다.")
            void throwIllegalArgumentException() {
                Assertions.assertThatThrownBy(() -> Asserts.isFalse(trueInput, () -> "false값이 들어올 수 없습니다."))
                    .isInstanceOf(IllegalArgumentException.class);
            }

        }

    }

}
