package racingcar.utils;

import org.junit.jupiter.api.Test;
import racingcar.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilsTest {
    @Test
    void repeatDash() {
        assertThat(StringUtils.repeat("-", 3)).isEqualTo("---");
        assertThat(StringUtils.repeat("=", 4)).isEqualTo("====");
    }

    @Test
    void namesListTest() {
        List<String> testList = new ArrayList<>();
        testList.add("min");
        testList.add("max");
        assertThat(StringUtils.getNames(testList, ":")).isEqualTo("min:max");
        assertThat(StringUtils.getNames(testList, ", ")).isEqualTo("min, max");
    }
}
