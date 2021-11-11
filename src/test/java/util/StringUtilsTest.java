package util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racingcar.RacingCarTestUtil.IDENTIFIER_OF_CARS;
import static racingcar.RacingCarTestUtil.NAMES_OF_CARS;
import static util.StringUtils.separateStringWithComma;

public class StringUtilsTest {

    @Test
    void testSeparateStringWithComma() {
        String[] separatedNames = separateStringWithComma(IDENTIFIER_OF_CARS);
        assertThat(separatedNames).isEqualTo(NAMES_OF_CARS);
    }
}
