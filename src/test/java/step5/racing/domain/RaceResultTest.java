package step5.racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class RaceResultTest {

    @Test
    void 하나의_라운드_결과를_저장한다() {
        RaceResult raceResult = new RaceResult();

        RoundResult roundResult = new RoundResult(List.of(
                new CarResult("자동차1", 3),
                new CarResult("자동차2", 4),
                new CarResult("자동차2", 2)
        ));
        raceResult.addRoundResult(roundResult);

        assertThat(raceResult.getRaceResult()).hasSize(1);
    }

    @Test
    void 여러_라운드_결과를_저장한다() {
        RaceResult raceResult = new RaceResult();

        RoundResult round1 = new RoundResult(List.of(
                new CarResult("자동차1", 1), new CarResult("자동차2", 0)
        ));
        RoundResult round2 = new RoundResult(List.of(
                new CarResult("자동차1", 1), new CarResult("자동차2", 1)
        ));

        raceResult.addRoundResult(round1);
        raceResult.addRoundResult(round2);

        assertThat(raceResult.getRaceResult()).hasSize(2);
    }
}
