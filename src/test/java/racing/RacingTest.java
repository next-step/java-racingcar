package racing;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingTest {

    @BeforeEach
    @DisplayName("초기 작업")
    void init() {
        String simulatedInput = "5\n3\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
    }

    @Test
    @DisplayName("몇 대의 자동차로 몇 번 이동할 수 있는지 확인")
    void initTest() {
        Racing racing = new Racing();
        racing.init();
        assertAll(
            () -> assertThat(racing.carCount).isEqualTo(5),
            () -> assertThat(racing.moveCount).isEqualTo(3)
        );
    }
}
