package step1.racing;

import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

class StatusMonitorTest {
    private StatusMonitor sut = new StatusMonitor();

    @Test
    void throws_exception_not_integer_type_input() {
        InputOutput inputOutput= new InputOutput();

        String input = "a";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("add 5", inputOutput. ());
        assertThatThrownBy(() -> sut.play()).isInstanceOf(IllegalArgumentException.class);
    }
}
