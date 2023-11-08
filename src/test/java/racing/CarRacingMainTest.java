package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class CarRacingMainTest {
    private static final String NUMBER = "number";
    private static final String COUNT = "count";

    @BeforeEach
    public void init() {
        Map<String, Integer> map = new HashMap<>();
        map.put(NUMBER, 3);
        map.put(COUNT, 5);
        ResultView.init(map);
    }

    @Test
    public void testArraySize() {
        String[][] result = ResultView.value();
        assertThat(result.length).isEqualTo(5);
        assertThat(result[0].length).isEqualTo(3);
    }

    @Test
    public void testConcat() {
        ResultView.concat(0, 0, "-");
        ResultView.concat(1, 0, "");
        assertThat(ResultView.value()[1][0]).isEqualTo("-");

        ResultView.concat(2, 0, "-");
        assertThat(ResultView.value()[2][0]).isEqualTo("--");

        ResultView.concat(0, 1, "-");
        ResultView.concat(1, 1, "-");
        ResultView.concat(2, 1, "-");
        assertThat(ResultView.value()[2][1]).isEqualTo("---");
    }
}