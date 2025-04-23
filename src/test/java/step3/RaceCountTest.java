package step3;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RaceCountTest {

    @DisplayName("play()를 호출하면 회차가 진행되면서 count가 감소한다")
    @Test
    void decreaseRaceCount() {
        RaceCount raceCount = new RaceCount(2);

        raceCount.play(() -> List.of());

        assertThat(raceCount.isDone()).isFalse();
    }
}