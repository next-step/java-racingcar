package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingTest {

    @DisplayName(value = "carNames에서 얻은 자동차 수만큼 차를 생성한다.")
    @Test
    void createCar() {
        RacingInfo info = new RacingInfo(Arrays.asList("a", "b", "c", "d"), 0);
        Racing racing = new Racing(info);
        assertThat(racing.getCars()).hasSize(4);
    }
}
