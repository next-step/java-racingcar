package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    @DisplayName("RacingGame 실행시 입력받은 자동차 대수, 시도할 회수로 실행한 결과가 반환된다.")
    void runRacingGame() {

        //given
        List<String> carNameList = Arrays.asList("a", "b");
        int runCount = 3;

        //when
        RacingGame racingGame = new RacingGame();
        List<Records> records = racingGame.run(carNameList, 3);

        //then
        assertThat(records).hasSize(runCount);
        assertThat(records.get(0).getCarRecords()).hasSize(carNameList.size());
    }
}
