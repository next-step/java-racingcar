package racing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RaceInfoTest {

    @Test
    void RaceInfo_생성() {
        RaceInfo raceInfo = new RaceInfo(new String[]{"a", "b"}, 5);
        String[] names = raceInfo.nameData();
        int trials = raceInfo.trialData();

        assertThat(names[1]).isEqualTo("b");
        assertThat(trials).isEqualTo(5);
    }
}