package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class RaceResultTest {

    @Test
    void 경주_결과에_라운드_결과를_추가할_수_있다() {
        RaceResult raceResult = new RaceResult();
        RoundResult roundResult = new RoundResult(List.of(
                new CarResult(new CarName("자동차1"), new Position(1)),
                new CarResult(new CarName("자동차2"), new Position(2)),
                new CarResult(new CarName("자동차3"), new Position(3))
        ));

        raceResult.addResult(roundResult);
        assertThat(raceResult.getRaceResult()).hasSize(1);
    }
}
