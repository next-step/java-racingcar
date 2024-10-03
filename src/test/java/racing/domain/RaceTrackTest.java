package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.constant.RacePosition;
import racing.dto.RaceInfo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RaceTrackTest {

    RaceInfo input = new RaceInfo("pobi,crong,honux", 5);
    RaceTrack track = new RaceTrack(input);

    @BeforeEach
    void prepare() {
        track.race(new RandomNumRaceRule());
    }

    @Test
    void race() {
        RaceResult raceResult = track.getRaceResult();

        assertThat(raceResult.count()).isEqualTo(input.raceLineUp().count());

        raceResult.stream().forEach(raceRecord -> {
            for (int i = 0; i < input.attemptNumber().getValue(); i++) {
                assertThat(raceRecord.raceResult(i)).isNotNull();
            }
        });
    }
}