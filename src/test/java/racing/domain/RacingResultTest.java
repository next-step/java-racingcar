package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingResultTest {

    @DisplayName("들어온 자동차 리스트를 레이싱 리스트에 저장해야 한다.")
    @Test
    void saveResult() {
        RacingResult racingResult = new RacingResult();
        racingResult.save(Arrays.asList(new CarResult("eo", 4), new CarResult("hae", 4)));

        assertThat(racingResult.getRacingResult()).hasSize(1);
        assertThat(racingResult.getLastRoundResult()).hasSize(2);
    }
}
