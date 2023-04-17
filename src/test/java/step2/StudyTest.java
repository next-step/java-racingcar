package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.junit.jupiter.api.Assertions.assertAll;

public class StudyTest {

    @DisplayName("문자열 split 테스트")
    @ParameterizedTest(name = "{displayName} {index} = {0}을/를 , 로 split -> 사이즈: {1}, 결과: {2}")
    @MethodSource
    void split(String input, int size, List<String> expected) {
        String[] values = input.split(",");

        assertSoftly(softAssertions -> {
            softAssertions.assertThat(values).hasSize(size);
            softAssertions.assertThat(values).containsExactlyElementsOf(expected);
        });
    }

    private static Stream<Arguments> split() {
        return Stream.of(
                Arguments.arguments("1,2", 2, List.of("1", "2")),
                Arguments.arguments("1", 1, List.of("1"))
        );
    }

    @DisplayName("matcher 테스트")
    @Test
    void matcher() {
        String regex = "//(.)\n(.*)";
        String input = "//;\n1;2;3";

        Pattern customPattern = Pattern.compile(regex);
        Matcher m = customPattern.matcher(input);

        assertThat(m.find()).isEqualTo(true);
        assertThat(m.group(1)).isEqualTo(";");
        assertThat(m.group(2)).isEqualTo("1;2;3");
    }

}
