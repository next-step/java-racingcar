package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void substring() {
        final String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Nested
    @DisplayName("chatAt")
    class CharAt {
        final String mockString = "012";
        final int outOfIndex = 3;
        final String expectingOutOfRangeMessage = "String index out of range: " + outOfIndex;

        @DisplayName("valid index access")
        @Test
        void charAt() {
            final char result = mockString.charAt(0);
            assertThat(result).isEqualTo('0');
        }
        
        @DisplayName("throw StringIndexOutOfBoundsException test using assertThatThrownBy")
        @Test
        void throw_StringIndexOutOfBoundsException_test_using_assertThatThrownBy_when_string_index_out_of_range() {
            assertThatThrownBy(() -> {
                mockString.charAt(outOfIndex);
            }).isInstanceOf(StringIndexOutOfBoundsException.class)
                    .hasMessageContaining(expectingOutOfRangeMessage);

        }

        @DisplayName("throw StringIndexOutOfBoundsException test using assertThatExceptionOfType")
        @Test
        void throw_StringIndexOutOfBoundsException_test_using_assertThatExceptionOfType_when_string_index_out_of_range() {
            assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                    .isThrownBy(() -> {
                        mockString.charAt(outOfIndex);
                    }).withMessageMatching(expectingOutOfRangeMessage);
        }

        @DisplayName("throw StringIndexOutOfBoundsException test using catchThrowable")
        @Test
        void throw_StringIndexOutOfBoundsException_test_using_catchThrowable_when_string_index_out_of_range() {
            // when
            final Throwable thrown = catchThrowable(() -> {  mockString.charAt(outOfIndex); });

            // then
            assertThat(thrown).isInstanceOf(StringIndexOutOfBoundsException.class)
                    .hasMessageContaining(expectingOutOfRangeMessage);
        }

        @DisplayName("throw NullPointerException test using assertThatNullPointerException")
        @Test
        void throw_NullPointerException_test_using_assertThatNullPointerException_when_string_is_null() {
            // given some preconditions
            final String nullMockString = null;
            
            assertThatNullPointerException().isThrownBy(() -> nullMockString.charAt(0))
                    .withNoCause();
        }
    }

}
