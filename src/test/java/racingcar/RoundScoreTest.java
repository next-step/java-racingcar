package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.model.RoundScore;

public class RoundScoreTest {

    @Test
    void 자동차가_최대_이동한거리인지_확인() {
        String carName = "test";
        int maxScore = 4;
        RoundScore roundScore = new RoundScore(carName, 4);

        Assertions.assertThat(roundScore.hasMaxDistance(maxScore)).isTrue();
    }
}
