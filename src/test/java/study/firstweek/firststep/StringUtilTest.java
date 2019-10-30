package study.firstweek.firststep;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringUtilTest {

    private Calculator calculator = new Calculator();
    private StringUtils utils = new StringUtils();

    @DisplayName("empty test")
    @Test
    void emptyTest() {
        assertThat(utils.isEmpty(" ")).isTrue();
    }

    @DisplayName("is not empty test")
    @Test
    void isNotEmptyTest() {
        assertThat(utils.isNotEmpty(" 1")).isTrue();
    }

    @DisplayName("even number input test")
    @Test
    void wrongInputTest1() {
        List<String> test = Arrays.asList("1", "2", "3");
        assertThat(utils.isEvenInputLength(test)).isFalse();
    }
}
