package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class RaceResultTest {

    @Test
    void 경주_결과에_라운드_결과를_추가할_수_있다() {
        RaceResult raceResult = new RaceResult();
        RoundResult roundResult = new RoundResult(List.of(1, 2, 3));

        raceResult.addResult(roundResult);
        assertThat(raceResult.getRaceResult()).hasSize(1);
    }
}
