package racing;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    @Test
    @DisplayName("자동차 생성")
    void create() {
        RacingCar actual = new RacingCar();
        assertThat(actual).isNotNull();
    }
}

