package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.model.RoundScore;
import racingcar.model.RoundScores;

import java.util.ArrayList;
import java.util.List;

public class RoundScoresTest {

    @Test
    void 우승자_테스트() {
        List<RoundScore> testScore = new ArrayList<>();
        testScore.add(new RoundScore("철수", 4));
        testScore.add(new RoundScore("영희", 2));
        testScore.add(new RoundScore("영수", 3));

        RoundScores roundScores = new RoundScores(testScore);
        Assertions.assertThat(roundScores.getWinner().contains("철수")).isTrue();

    }
}
