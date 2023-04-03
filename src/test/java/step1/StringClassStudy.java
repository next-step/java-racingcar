package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringClassStudy {

    @Nested
    @DisplayName("[요구사항1] 쉼표로 구분된 문자열 ")
    class Describe_CommaSeparatedString {

        private final static String DELIMITER = ",";

        @Nested
        @DisplayName("1,2이 주어진다면")
        class Context_with_ONE_DELIMITER_TWO_String {

            private final static String GIVEN_STRING = "1,2";
            private final String[] SHOULD_RETURN_ARRAY = {"1", "2"};

            @Test
            @DisplayName("1과 2로 구성된 배열을 반환한다")
            void returnStringArray() {

                String[] result = GIVEN_STRING.split(DELIMITER);

                assertThat(result).containsExactly(SHOULD_RETURN_ARRAY);
            }
        }

        @Nested
        @DisplayName("1,이 주어진다면")
        class Context_with_ONE_DELIMITER_String {

            private final static String GIVEN_STRING = "1,";
            private final String[] SHOULD_RETURN_ARRAY = {"1"};

            @Test
            @DisplayName("1로 구성된 배열을 반환한다")
            void returnStringArray() {

                String[] result = GIVEN_STRING.split(DELIMITER);

                assertThat(result).containsExactly(SHOULD_RETURN_ARRAY);
            }
        }
    }

}
