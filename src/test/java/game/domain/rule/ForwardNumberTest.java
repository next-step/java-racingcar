package game.domain.rule;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ForwardNumberTest {

    @Test
    void create() {
        ForwardNumber forwardNumber = new ForwardNumber(4);

        assertThat(forwardNumber).isEqualTo(new ForwardNumber(4));
    }

    @Test
    void valid() {
        assertThatThrownBy(() -> new ForwardNumber(-1)).isInstanceOf(IllegalArgumentException.class);
    }
}
