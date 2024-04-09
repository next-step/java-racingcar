package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RunTimesTest {

    @Test
    void 횟수_감소() throws Exception {
        RunTimes runTimes = new RunTimes(3);
        runTimes.decrease();
        assertThat(runTimes).isEqualTo(new RunTimes(2));
    }

    @Test
    void 게임_진행중() throws Exception {
        RunTimes runTimes = new RunTimes(3);
        assertThat(runTimes.isDuringGame()).isEqualTo(true);
    }

}
