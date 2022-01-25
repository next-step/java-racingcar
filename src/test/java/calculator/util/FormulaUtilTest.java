package calculator.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FormulaUtilTest {

    @Test
    void 연산쪼깨기(){
        List<String> result = new ArrayList<>(Arrays.asList("6 / 2 + 3".split(" ")));

        assertThat(result.size()).isEqualTo(5);
        assertThat(result.get(0)).isEqualTo("6");
        assertThat(result.get(1)).isEqualTo("/");
        assertThat(result.get(2)).isEqualTo("2");
        assertThat(result.get(3)).isEqualTo("+");
        assertThat(result.get(4)).isEqualTo("3");
    }
}