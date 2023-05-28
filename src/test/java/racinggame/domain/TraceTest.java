package racinggame.domain;

import org.junit.jupiter.api.Test;
import racinggame.domain.Trace;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TraceTest {
    @Test
    void create() {
        Trace trace = new Trace(3);
        assertThat(trace).isEqualTo(new Trace(3));
    }

    @Test
    void valid() {
        assertThatThrownBy(() -> {
            new Trace(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void move() {
        Trace trace = new Trace(3);
        assertThat(trace.move()).isEqualTo(new Trace(4));
    }
}
