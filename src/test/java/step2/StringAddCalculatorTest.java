package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import util.StringAddCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @DisplayName("split 메서드는 정규표현식을 통해 복수의 구분자로 문자열을 자를 수 있다")
    @Test
    void splitByRegExp() {
        final String input = ",|:";
        final String target = "1,2:3";

        final String[] split = target.split(input);

        assertThat(split).containsExactly("1", "2", "3");
    }

    @DisplayName("Matcher의")
    @Nested
    class Describe_Matcher {
        final Pattern pattern = Pattern.compile("//(.)\n(.*)");
        final String target = "//;\n1;2;3";

        @DisplayName("find()는 입력 받은 문자열에 패턴이 있을 경우 true를 반환한다")
        @Test
        void find() {
            final Matcher matcher = pattern.matcher(target);

            assertThat(matcher.find()).isTrue();
        }

        @DisplayName("group(n)은 매칭되는 문자열 중 n번째 그룹의 문자열을 반환한다")
        @Test
        void group() {
            final Matcher matcher = pattern.matcher(target);

            matcher.find();

            assertThat(matcher.group(1)).isEqualTo(";");
        }
    }

    @DisplayName("문자열 덧셈 계산기는")
    @Nested
    class Describe_StringAddCalculator {

        @DisplayName("빈 문자열이나 null 값을 입력할 경우")
        @Nested
        class Context_with_blank_string {

            @DisplayName("0을 반환한다")
            @ParameterizedTest
            @NullAndEmptySource
            void it_returns_zero(String input) {
                final int result = StringAddCalculator.splitAndSum(input);

                assertThat(result).isEqualTo(0);
            }
        }

        @DisplayName("문자열 계산기 조건에 부합하는 문자열인 경우")
        @Nested
        class Context_with_calculator_string_value_rules {

            @DisplayName("단일 숫자라면, 해당 숫자를 반환한다")
            @Test
            void it_returns_when_single_number_then_value_as_int() {
                final int result = StringAddCalculator.splitAndSum("1");

                assertThat(result).isEqualTo(1);
            }

            @DisplayName("쉼표 구분자라면, 구분자로 분리된 숫자들의 합을 반환한다")
            @Test
            void it_returns_when_string_with_comma_then_split_int_sum() {
                final int result = StringAddCalculator.splitAndSum("1,2");

                assertThat(result).isEqualTo(3);
            }

            @DisplayName("쉼표와 콜론이 섞인 구분자라면, 구분자들로 분리된 숫자들의 합을 반환한다")
            @Test
            void it_returns_when_string_with_comma_and_colons_then_split_int_sum() {
                final int result = StringAddCalculator.splitAndSum("1,2:3");

                assertThat(result).isEqualTo(6);
            }

            @DisplayName("커스텀 구분자 ;를 조건에 맞게 입력한 경우, 구분자들로 분리된 숫자들의 합을 반환한다")
            @Test
            void it_returns_when_string_with_custom_delimiter_then_split_int_sum() {
                final int result = StringAddCalculator.splitAndSum("//;\n1;2;3");

                assertThat(result).isEqualTo(6);
            }
        }

        @DisplayName("구분된 문자열이 숫자 형식이 아닌 경우")
        @Nested
        class Context_with_string_split_value {

            @DisplayName("NumberFormatException을 반환한다")
            @ParameterizedTest
            @ValueSource(strings = {"+", "1,2:가", "//;\n", "//;\n1;가"})
            void it_throws_number_format_exception(String value) {
                assertThatThrownBy(() -> StringAddCalculator.splitAndSum(value))
                        .isInstanceOf(NumberFormatException.class);
            }
        }

        @DisplayName("구분된 문자열이 음수를 포함하고 있는 경우")
        @Nested
        class Context_with_negative_value {

            @DisplayName("IllegalArgumentsException을 반환한다")
            @ParameterizedTest
            @ValueSource(strings = {"-1", "1,2:-1", "//;\n-1", "//;\n1;-1"})
            void it_throws_illegalArgumentException(String value) {
                assertThatThrownBy(() -> StringAddCalculator.splitAndSum(value))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("문자열 덧셈 계산기는 음수를 지원하지 않습니다.");
            }
        }
    }

}
