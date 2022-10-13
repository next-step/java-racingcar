package racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarDistanceTest {
    @Test
    void test_negative_number() {
        assertThatThrownBy(() -> new CarDistance(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void test_add() {
        assertThat(new CarDistance().add(3)).isEqualTo(new CarDistance(3));
    }

    @Test
    void test_compare_to() {
        assertThat(new CarDistance(1).compareTo(new CarDistance(2))).isEqualTo(-1);
        assertThat(new CarDistance(2).compareTo(new CarDistance(2))).isEqualTo(0);
        assertThat(new CarDistance(3).compareTo(new CarDistance(2))).isEqualTo(1);
    }
}
