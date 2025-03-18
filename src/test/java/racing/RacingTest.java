package racing;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingTest {

    int simulateCarCount = 3;
    int simulateMoveCount = 5;
    Racing racing;

    @BeforeEach
    @DisplayName("초기 작업")
    void init() {
        String simulatedInput = simulateCarCount + "\n" + simulateMoveCount + "\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        racing = new Racing();
        racing.init();
    }

    @Test
    @DisplayName("몇 대의 자동차로 몇 번 이동할 수 있는지 확인")
    void initTest() {
        assertAll(
            () -> assertThat(racing.carCount).isEqualTo(simulateCarCount),
            () -> assertThat(racing.moveCount).isEqualTo(simulateMoveCount)
        );
    }

    @Test
    @DisplayName("자동차 이동 검증테스트")
    void runTest() {
        racing.run();
        CarGroup carGroup = racing.cars;
        assertThat(carGroup.cars.size()).isEqualTo(simulateCarCount);
        for (int i=0; i<simulateCarCount; i++) {
            assertThat(carGroup.cars.get(i).position).isBetween(0, simulateMoveCount);
        }
    }
}
