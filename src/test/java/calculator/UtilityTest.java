package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;


class UtilityTest {

    @Test
    @DisplayName("splitFormula Test")
    void splitFormula() {
        String test = "2+3/4";
        String operatorRegex = "[0-9]+";
        String operandRegex = "[-+*/()]";
        assertThat(Utility.splitFormula(test, operatorRegex)).isEqualTo(Arrays.asList("+", "/"));
        assertThat(Utility.splitFormula(test, operandRegex)).isEqualTo(Arrays.asList("2", "3", "4"));
    }

    @Test
    @DisplayName("stringToDouble Test")
    void stringToDouble() {
        ArrayList<String> test = new ArrayList<>(Arrays.asList("3", "1", "2"));
        assertThat(Utility.stringToDouble(test)).isEqualTo(Arrays.asList(3.0, 1.0, 2.0));
    }
}