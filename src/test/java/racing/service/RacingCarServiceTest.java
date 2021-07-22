package racing.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarServiceTest {

    @Test
    @DisplayName("경주 후 자동차 이동 확인")
    void randomPlay() {
        StringBuffer racingSign = new StringBuffer();
        for (int i = 0; i < 5; i++) {
            racingSign = RacingCarService.randomPlay(racingSign);
        }
        assertThat(racingSign).isNotBlank();
    }
}