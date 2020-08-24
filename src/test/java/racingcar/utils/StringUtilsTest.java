package racingcar.utils;

import org.junit.jupiter.api.Test;
import static racingcar.utils.StringUtils.*;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilsTest {
    @Test
    void repeatDash() {
        assertThat(repeat("-", 3)).isEqualTo("---");
        assertThat(repeat("=", 4)).isEqualTo("====");
    }

    @Test
    void namesListTest() {
        List<String> testList = new ArrayList<>();
        testList.add("min");
        testList.add("max");
        assertThat(getNames(testList, ":")).isEqualTo("min:max");
        assertThat(getNames(testList, ", ")).isEqualTo("min, max");
    }
}
