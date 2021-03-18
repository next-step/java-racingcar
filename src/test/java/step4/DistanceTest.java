package step4;

import org.junit.jupiter.api.Test;
import step4.model.Distance;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DistanceTest {
    @Test
    void create() {
        assertThat(new Distance(1)).isEqualTo(new Distance(1));
        assertThat(new Distance()).isEqualTo(new Distance(0));
    }

    @Test
    void invalid() {
        assertThatThrownBy(() -> new Distance(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void increase() {
        assertThat(new Distance(1).increase()).isEqualTo(new Distance(2));
    }
}
