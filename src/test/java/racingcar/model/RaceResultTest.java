package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class RaceResultTest {

    @Test
    void 라운드_후_레이싱결과를_올바르게_반환한다() {
        RaceResult raceResult = new RaceResult
            (Arrays.asList(new Car("jiin", 1), new Car("leah", 0),
                new Car("sam", 1)));
        List<Car> raceResultByRound = raceResult.getRaceResultByRound();
        assertThat(raceResultByRound.get(0).getCarName()).isEqualTo("jiin");
        assertThat(raceResultByRound.get(0).getPosition()).isEqualTo(1);
        assertThat(raceResultByRound.get(1).getCarName()).isEqualTo("leah");
        assertThat(raceResultByRound.get(1).getPosition()).isEqualTo(0);
        assertThat(raceResultByRound.get(2).getCarName()).isEqualTo("sam");
        assertThat(raceResultByRound.get(2).getPosition()).isEqualTo(1);
    }

}