package racing.race;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.input.RaceInput;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RaceTrackTest {

    RaceInput input = new RaceInput("pobi,crong,honux", 5);
    RaceTrack track = new RaceTrack(input);

    @BeforeEach
    void prepare() {
        track.race(new RandomNumRaceRule());
    }

    @Test
    void race() {
        List<RaceRecord> raceRecords = track.getRaceResult();

        assertThat(raceRecords).hasSize(input.carInfo().count());
        for (RaceRecord raceRecord : raceRecords) {
            for (int i = 0; i < input.getAttemptNumber().getValue(); i++) {
                assertThat(raceRecord.raceResult(i)).isIn(RacePosition.FORWARD, RacePosition.STOP);
            }
            assertThat(raceRecord.raceResult(input.getAttemptNumber().getValue() - 1))
                    .isInstanceOf(RacePosition.class);
        }
    }

    @Test
    void 레코드_값_추가불가() {
        List<RaceRecord> raceRecords = track.getRaceResult();

        assertThatThrownBy(() -> raceRecords.add(new RaceRecord(new ArrayList<>())))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void 레코드_값_제거불가() {
        List<RaceRecord> raceRecords = track.getRaceResult();

        assertThatThrownBy(() -> raceRecords.remove(raceRecords.size() - 1))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void 레코드_재할당_시_원본유지() {
        List<RaceRecord> raceRecords = track.getRaceResult();

        assertThatThrownBy(() -> raceRecords.set(raceRecords.size() - 1, new RaceRecord(new ArrayList<>())))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
