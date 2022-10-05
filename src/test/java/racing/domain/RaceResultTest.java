package racing.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RaceResultTest {

    @Test
    void 기록중_가장_멀리간_기록_조회() {
        Record 빵빵이 = new Record("빵빵이", 5);
        Record 씽씽이 = new Record("씽씽이", 4);
        Record 쌩쌩이 = new Record("쌩쌩이", 5);
        RaceResult raceResult = new RaceResult(
                List.of(빵빵이, 씽씽이, 쌩쌩이)
        );

        Assertions.assertThat(raceResult.winners())
                .hasSize(2)
                .containsExactly(빵빵이, 쌩쌩이);
    }

}