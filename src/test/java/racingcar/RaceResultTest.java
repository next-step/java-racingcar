package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.*;

public class RaceResultTest {

    @DisplayName("경기기록 수 체크")
    @Test
    void 경기횟수_체크() {
        Cars cars = new Cars();
        RaceResult raceResult = new RaceResult();
        raceResult.record(cars);
        raceResult.record(cars);
        raceResult.record(cars);

        Assertions.assertThat(raceResult.getRaceRecord().size()).isEqualTo(3);


    }
}
