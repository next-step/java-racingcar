package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class TestCarName {
    @Test
    void create_empty_name() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
           new CarName("");
        });
    }

    @Test
    void create_within_max_length() {
        assertThat(new CarName("K")).isEqualTo(new CarName("K"));
        assertThat(new CarName("KK")).isEqualTo(new CarName("KK"));
        assertThat(new CarName("BMW")).isEqualTo(new CarName("BMW"));
        assertThat(new CarName("AUDI")).isEqualTo(new CarName("AUDI"));
        assertThat(new CarName("VOLVO")).isEqualTo(new CarName("VOLVO"));
    }

    @Test
    void create_exceed_max_length() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new CarName("JAGUAR");
        });
    }
}
