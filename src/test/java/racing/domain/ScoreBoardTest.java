package racing.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racing.domain.race.RaceResult;
import racing.domain.race.Record;
import racing.domain.race.ScoreBoard;

import java.util.List;

class ScoreBoardTest {

    @Test
    void 마지막_우승자_기록_조회() {
        ScoreBoard scoreBoard = new ScoreBoard();
        Record 빵빵이 = new Record("빵빵이", 1);
        Record 씽씽이 = new Record("씽씽이", 1);
        Record 쌩쌩이 = new Record("쌩쌩이", 1);
        scoreBoard.addResult(new RaceResult(List.of(빵빵이, 씽씽이, 쌩쌩이)));

        Record 빵빵이2 = new Record("빵빵이", 2);
        Record 씽씽이2 = new Record("씽씽이", 1);
        Record 쌩쌩이2 = new Record("쌩쌩이", 2);
        scoreBoard.addResult(new RaceResult(List.of(빵빵이2, 씽씽이2, 쌩쌩이2)));

        Assertions.assertThat(scoreBoard.winners()).hasSize(2)
            .containsExactly(new Record("빵빵이", 2), new Record("쌩쌩이", 2));
    }

}