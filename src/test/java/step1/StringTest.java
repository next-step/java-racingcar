package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @DisplayName("String의 split 메서드는")
    @Nested
    class Describe_split {
        final String TEST_SEPARATOR = ",";

        @DisplayName("구분자를 포함하고 있는 경우")
        @Nested
        class Context_with_separator_contained_string {

            @DisplayName("구분자를 기준으로 나누어진 문자열 배열을 반환한다")
            @Test
            void it_returns_array_separated_by_separator() {
                final String input = "1,2";

                final String[] splitString = input.split(TEST_SEPARATOR);

                assertThat(splitString).containsExactly("1", "2");
            }
        }

        @DisplayName("구분자를 포함하고 있지 않는 경우")
        @Nested
        class Context_with_string_except_separator {

            @DisplayName("입력 문자열만을 갖는 길이 1의 문자열 배열을 반환한다")
            @Test
            void it_returns_array_with_singleton_array_with_only_input() {
                final String input = "1";

                final String[] splitString = input.split(TEST_SEPARATOR);

                assertThat(splitString).containsExactly("1");
            }

        }
    }

}