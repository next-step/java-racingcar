package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class RegexTest {

    @ParameterizedTest
    @DisplayName("어떤 문자 1개를 의미하는 정규 표현식")
    @ValueSource(strings = {"ear", "horse", "3", "k"})
    void 점(String given) {
        // given
        String regex = ".";

        // when
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(given);
        boolean result = matcher.find();

        // then
        assertThat(result).isEqualTo(true);
    }

    @ParameterizedTest
    @DisplayName("처음 문자열이 regex로 시작하는 지 검증")
    @ValueSource(strings = {"regextgd", "regex", "regex45234"})
    void start_with_regex(String given) {
        // given
        String regex = "^regex";

        // when
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(given);
        boolean result = matcher.find();

        // then
        assertThat(result).isEqualTo(true);
    }

    @ParameterizedTest
    @DisplayName("문자열이 regex로 끝나는 지 검증")
    @ValueSource(strings = {"32regex", "regex", "regeregex"})
    void end_with_regex(String given) {
        // given
        String regex = "regex$";

        // when
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(given);
        boolean result = matcher.find();

        // then
        assertThat(result).isEqualTo(true);
    }

    @ParameterizedTest
    @DisplayName("문자열이 r로 시작해 x로 끝나는지 검증")
    @ValueSource(strings = {"r123x", "rx1234rx", "rx"})
    void start_with_r_and_end_with_x(String given) {
        // given
        String regex = "^r(.*)x$";

        // when
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(given);
        boolean result = matcher.find();

        // then
        assertThat(result).isEqualTo(true);
    }

    @ParameterizedTest
    @DisplayName("문자열에 [abc] 중 하나라도 존재한다.")
    @ValueSource(strings = {"abc", "123789ac2", "ca", "a"})
    void text_contains_least_one_value(String given) {
        // given
        String regex = "[abc]";

        // when
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(given);
        boolean result = matcher.find();

        // then
        assertThat(result).isEqualTo(true);
    }

    @ParameterizedTest
    @DisplayName("문자열에 [abc] 중 하나로 시작해 [abc]중 하나로 끝나야 한다.")
    @ValueSource(strings = {"abc", "c123789ac2a", "c1a"})
    void regex_test(String given) {
        // given
        String regex = "^[abc](.*)[abc]$";

        // when
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(given);
        boolean result = matcher.find();

        // then
        assertThat(result).isEqualTo(true);
    }

    @ParameterizedTest
    @DisplayName("문자열에 [abc]와 [xy]에서 최소한 1개씩 택한 문자로 시작해 [abc]중 하나로 끝나야 한다."
            + "(참고) -> [abc]와 [xy]의 순서는 중요하다!)")
    @ValueSource(strings = {"aybc", "axbcya", "cyb", "axcba"})
    void regex_test2(String given) {
        // given
        String regex = "^[abc][xy](.*)[abc]$";

        // when
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(given);
        boolean result = matcher.find();

        // then
        assertThat(result).isEqualTo(true);
    }

    @ParameterizedTest
    @DisplayName("문자열이 [abc] 을 제외한 문자 1개, [xy]를 제외한 문자 1개로 시작하는지 검증")
    @CsvSource(value = {"rx, false", "xax, true", "x321, true"})
    void regex_test3(String given, boolean expected) {
        // given
        String regex = "^[^abc][^xy]";

        // when
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(given);
        boolean result = matcher.find();

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("문자열이 a ~ d 나 1 ~ 5 사이의 문자로 시작하는지 검증")
    @CsvSource(value = {"a123, true", "ekl, false", "7op, false"})
    void regex_test4(String given, boolean expected) {
        // given
        String regex = "^[a-d1-5]";

        // when
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(given);
        boolean result = matcher.find();

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("문자열이 a ~ d 또는 1 ~ 5 사이의 문자로 시작하는지 검증")
    @CsvSource(value = {"a123, true", "ekl, false", "7op, false"})
    void regex_test5(String given, boolean expected) {
        // given
        String regex = "^[a-d|1-5]";

        // when
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(given);
        boolean result = matcher.find();

        // then
        assertThat(result).isEqualTo(expected);
    }
}
