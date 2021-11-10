package util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static util.StringUtils.separateStringWithComma;

public class StringUtilsTest {
    private final String NAMES = "pobi, tomo, crong, honux, yong";
    private final String[] SEPARATED_NAMES = new String[]{"pobi", "tomo", "crong", "honux", "yong"};

    @Test
    void testSeparateStringWithComma() {
        String[] separatedNames = separateStringWithComma(NAMES);
        assertThat(separatedNames).isEqualTo(SEPARATED_NAMES);
    }
}
