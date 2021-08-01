package race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.model.Distance;

import static org.assertj.core.api.Assertions.assertThat;

public class DistanceTest {

    @Test
    @DisplayName("create Distance Test")
    void createDistanceTest() {
        Distance distance = new Distance(3);
        assertThat(distance).isEqualTo(new Distance(3));
    }

    @Test
    @DisplayName("forward move Test")
    void forwardDistanceTest() {
        Distance distance = new Distance(3);
        assertThat(distance.forward()).isEqualTo(new Distance(4));
    }
}
