package study;

import org.junit.jupiter.api.Test;
import racing.CarRacing;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingTest {
    private static CarRacing carRacing = new CarRacing();

    @Test
    void 경주를_하고나면_결과를_발표한다() {
        assertThat(carRacing.play()).isEqualTo("실행 결과");
    }
}
