package racing.v1.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingServiceTest {
    @Test
    @DisplayName("초기 생성 시 자동차 수, 횟수 0")
    void step1() {
        assertThat(new RacingService().getCarCount()).isEqualTo(0);
        assertThat(new RacingService().getMoveCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 수 입력 시 설정된 자동차 수와 동일")
    void step2() {
        RacingService racingService = new RacingService();

        racingService.setCarCount(1);
        racingService.setMoveCount(1);

        assertThat(racingService.getCarCount()).isEqualTo(1);
        assertThat(racingService.getMoveCount()).isEqualTo(1);
    }
}
