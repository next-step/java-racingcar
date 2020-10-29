package StringInputCalcualtor;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

class ArgumentCollectorTest {

    @Test
    void testCollectFromArgs() {
        String sample = "2 + 3 * 4 / 2";
        ArgumentCollector argumentCollector = new ArgumentCollector(sample.split(" "));
        String result = argumentCollector.collect();
        assertThat(result).isEqualTo(sample);
    }

    @Test
    void testCollectFromStdin() {
        String sample = "2 + 3 * 4 / 2";

        ByteArrayInputStream in = new ByteArrayInputStream(sample.getBytes());
        System.setIn(in);

        ArgumentCollector argumentCollector = new ArgumentCollector(new String[]{});
        String result = argumentCollector.collect();

        assertThat(result).isEqualTo(sample);
    }
}