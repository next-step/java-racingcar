package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import util.StringAddCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

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

    }
}
