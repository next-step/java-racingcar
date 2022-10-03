package domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    @Test
    void 자동차_갯수만큼_생성() {
        Racing racing = new Racing(3);
        assertThat(racing.getCars()).hasSize(3);
    }
}
