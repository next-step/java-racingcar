package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameResultTest {

    @DisplayName("라운드 결과가 같으면 자동차 경주 결과는 같아야 한다.")
    @Test
    void equalsAndHashCode() {
        RacingGameRoundResult round1 = new RacingGameRoundResult(
                List.of(
                        new RacingGameCarResult("car1", 0),
                        new RacingGameCarResult("car2", 1),
                        new RacingGameCarResult("car3", 2)
                )
        );
        RacingGameResult result1 = new RacingGameResult(List.of(round1));
        RacingGameRoundResult round2 = new RacingGameRoundResult(
                List.of(
                        new RacingGameCarResult("car1", 0),
                        new RacingGameCarResult("car2", 1),
                        new RacingGameCarResult("car3", 2)
                )
        );
        RacingGameResult result2 = new RacingGameResult(List.of(round2));

        assertThat(result1).isEqualTo(result2);
    }

    @DisplayName("마지막 라운드에서 위치가 가장 먼 자동차가 우승자여야 한다.")
    @Test
    void getWinner() {
        RacingGameRoundResult round1 = new RacingGameRoundResult(
                List.of(
                        new RacingGameCarResult("car1", 0),
                        new RacingGameCarResult("car2", 1),
                        new RacingGameCarResult("car3", 0)
                )
        );
        RacingGameRoundResult round2 = new RacingGameRoundResult(
                List.of(
                        new RacingGameCarResult("car1", 0),
                        new RacingGameCarResult("car2", 1),
                        new RacingGameCarResult("car3", 1)
                )
        );
        RacingGameResult result = new RacingGameResult(List.of(round1, round2));

        assertThat(result.getWinnerNames()).containsExactly("car2", "car3");
    }

}
