package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @DisplayName("자동차 전진 테스트")
    @Test
    void straight() {
        String result = Car.straight(3);
        assertThat(result).isEqualTo("");
    }

    @DisplayName("자동차 멈춤 테스트")
    @Test
    void stop() {
        String result = Car.stop();
        assertThat(result).isEqualTo("");
    }
}
