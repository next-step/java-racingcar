package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("String의 substring 메서드는")
    @Nested
    class Describe_substring {

        @DisplayName("시작 인덱스와 종료 인덱스를 받을 경우")
        @Nested
        class Context_with_proper_index {

            @DisplayName("시작 인덱스를 포함하여 (종료 위치 - 1) 인덱스 까지의 문자열을 반환한다")
            @Test
            void it_returns_substring() {
                final String input = "(1,2)";

                final String result = input.substring(1, 4);

                assertThat(result).isEqualTo("1,2");
            }
        }
    }

    @DisplayName("String의 charAt 메서드는")
    @Nested
    class Describe_charAt {

        @DisplayName("0이상 문자열 길이 미만의 인덱스를 입력받을 경우")
        @Nested
        class Context_with_index_zero_or_above_and_below_string_length {

            @DisplayName("문자열의 입력받은 index의 character를 반환한다")
            @Test
            void it_returns_character_at_the_input_index_of_string() {
                final String targetString = "abc";
                final int input = 1;

                final char result = targetString.charAt(input);

                assertThat(result).isEqualTo('b');
            }
        }

        @DisplayName("0미만 혹은 문자열 길이 이상의 인덱스를 입력받을 경우")
        @Nested
        class Context_with_index_below_zero_or_string_length_or_above {

            @DisplayName("StringIndexOutOfBoundsException 발생시킨다")
            @Test
            void it_throws_StringIndexOutOfBoundsException() {
                final String targetString = "abc";
                final int input = 321;

                assertThatThrownBy(() -> targetString.charAt(input))
                        .isInstanceOf(StringIndexOutOfBoundsException.class)
                        .hasMessageContaining("String index out of range: 321");
            }
        }
    }

}