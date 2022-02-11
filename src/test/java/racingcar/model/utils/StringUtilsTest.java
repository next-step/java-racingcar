package racingcar.model.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.utils.common.StringUtils;

public class StringUtilsTest {

    @DisplayName("문자열_split_테스트")
    @ParameterizedTest
    @ValueSource(strings = {"a,aa,aaa"})
    void splitStringTest(String input) {
        List<String> splitTest = new ArrayList(Arrays.asList("a", "aa", "aaa"));
        assertThat(StringUtils.splitUserInput(input)).isEqualTo(splitTest);
    }
}
