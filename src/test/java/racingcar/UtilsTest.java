package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static racingcar.utils.StringUtils.inputStringSeperator;

public class UtilsTest {
    @Test
    @DisplayName(", 구분자로 문자열 분리")
    void seperatorTest() {
        String inputStr = "pobi,crong,honux";
        String[] names = inputStringSeperator(inputStr);
        Assertions.assertArrayEquals(names, new String[]{"pobi", "crong", "honux"});
    }
}
