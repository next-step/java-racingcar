package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    void splitTestWithTwoNumber() {
        String string = "1,2";

        String[] actual = string.split(",");

        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    void splitWithOneNumber() {
        String string = "1,";

        String[] actual = string.split(",");

        assertThat(actual).containsExactly("1");
    }

    @Test
    void subString() {
        String string = "(1,2)";

        String actual = string.substring(1, 4);

        assertThat(actual).isEqualTo("1,2");
    }

    @Nested
    @DisplayName("charAt 메서드는")
    class Describe_charAt {
        private static final String STRING = "abc";

        @Nested
        @DisplayName("벗어나지 않은 위치 값이 주어지면")
        class Context_notExceedLocationValue {
            private final int NOT_EXCEED_LOCATION_VALUE = STRING.length() - 1;

            @Test
            @DisplayName("에러가 발생하지 않는다")
            void It_doesNotAnyThrows() {
                assertThatCode(() -> STRING.charAt(NOT_EXCEED_LOCATION_VALUE))
                        .doesNotThrowAnyException();
            }
        }

        @Nested
        @DisplayName("벗어난 위치 값이 주어지면")
        class Context_exceedLocationValue {
            private final int EXCEED_LOCATION_VALUE = STRING.length();

            @Test
            @DisplayName("StringIndexOutOfBoundsException을 던진다")
            void It_throwsStringIndexOutOfBoundsException() {
                assertThatThrownBy(() -> STRING.charAt(EXCEED_LOCATION_VALUE))
                        .isInstanceOf(StringIndexOutOfBoundsException.class);
            }
        }
    }
}
