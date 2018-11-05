package racing.dto;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameStatusTest {

    @Test
    public void 공동_승리자_찾기() {
        List<RacingCarStatus> racingCarStatuses = Arrays.asList(
                new RacingCarStatus("a", 0),
                new RacingCarStatus("b", 1),
                new RacingCarStatus("c", 1));

        RacingGameStatus racingGameStatus = new RacingGameStatus(racingCarStatuses);

        // b와 c를 공동우승으로 설정하면
        List<String> winners = racingGameStatus.getWinnerNames();

        assertThat(winners).containsExactly("b", "c");
    }

    @Test
    public void 승리자_찾기() {
        List<RacingCarStatus> racingCarStatuses = Arrays.asList(
                new RacingCarStatus("a", 1),
                new RacingCarStatus("b", 0));

        RacingGameStatus racingGameStatus = new RacingGameStatus(racingCarStatuses);

        // b와 c를 공동우승으로 설정하면
        List<String> winners = racingGameStatus.getWinnerNames();

        assertThat(winners).containsExactly("b");
    }

}