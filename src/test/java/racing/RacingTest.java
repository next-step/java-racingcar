package racing;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingTest {

    int simulateCarCount = 5;
    int simulateMoveCount = 3;

    @BeforeEach
    @DisplayName("초기 작업")
    void init() {
        String simulatedInput = simulateCarCount + "\n" + simulateMoveCount + "\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
    }

    @Test
    @DisplayName("몇 대의 자동차로 몇 번 이동할 수 있는지 확인")
    void initTest() {
        Racing racing = new Racing();
        racing.init();
        assertAll(
            () -> assertThat(racing.carCount).isEqualTo(simulateCarCount),
            () -> assertThat(racing.moveCount).isEqualTo(simulateMoveCount)
        );
    }

    @Test
    @DisplayName("자동차 이동 검증테스트")
    void runTest() {
        Racing racing = new Racing();
        racing.init();
        racing.run();
        assertAll(
            () -> assertThat(racing.cars.length).isEqualTo(simulateCarCount),
            () -> assertThat(racing.cars[0].position).isBetween(0, simulateMoveCount),
            () -> assertThat(racing.cars[1].position).isBetween(0, simulateMoveCount),
            () -> assertThat(racing.cars[2].position).isBetween(0, simulateMoveCount),
            () -> assertThat(racing.cars[3].position).isBetween(0, simulateMoveCount),
            () -> assertThat(racing.cars[4].position).isBetween(0, simulateMoveCount)
        );
    }
}
