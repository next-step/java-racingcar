package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class DistanceLogTest {
    DistanceLog distanceLog = new DistanceLog();

    @BeforeEach
    void distanceLogSetup() {
        distanceLog.addDistanceLog(1);
        distanceLog.addDistanceLog(0);
        distanceLog.addDistanceLog(2);
    }

    @DisplayName("자동차가 입력된 거리만큼 움직인 이후의 거리를 테스트")
    @Test
    void addMovedLogTest() {
        assertThat(distanceLog.getDistance()).isEqualTo(3);
    }

    @DisplayName("각 라운드별 자동차의 거리 테스트")
    @Test
    void getDistanceByRoundTest() {
        assertAll(
                () -> assertThat(distanceLog.getDistanceByRound(0)).isEqualTo(1),
                () -> assertThat(distanceLog.getDistanceByRound(1)).isEqualTo(1),
                () -> assertThat(distanceLog.getDistanceByRound(2)).isEqualTo(3)
        );
    }
}
