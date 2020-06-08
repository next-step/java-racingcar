package step4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RoundTest {

    @Test
    void create() {
        Round round = new Round(3);
        assertThat(round).isEqualTo(new Round(3));
    }

    @Test
    void round_is_valid() {
        assertThatThrownBy(() -> new Round(0)).isInstanceOf(IllegalArgumentException.class);
    }
}