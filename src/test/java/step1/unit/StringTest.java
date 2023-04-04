package step1.unit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    public static final String DELIMITER = ",";
    public static final String REPLACE_REGEX = "(|)";
    public static final String EMPTY_STRING = "";

    @ParameterizedTest(name = "Split Test - 순서 및 요소 확인 (input: ''{0}'')")
    @ValueSource(strings = {"1", "1,2", "3,4", "5,6,7"})
    void test_split_check_element(String input) {
        String[] split = input.split(DELIMITER);
        List<String> list = List.of(split);

        assertThat(list).contains(split);
        assertThat(list).containsExactly(split);
    }

    @ParameterizedTest(name = "Split Test - 괄호 제거 (input: ''{0}'')")
    @ValueSource(strings = {"(1)", "(1,2)", "(3,4)", "(5,6,7)"})
    void test_split_check_bracket(String input) {
        String replaceString = input.replaceAll(REPLACE_REGEX, EMPTY_STRING);
        String[] split = replaceString.split(DELIMITER);
        List<String> list = List.of(split);

        assertThat(list).contains(split);
        assertThat(list).containsExactly(split);
    }

}
