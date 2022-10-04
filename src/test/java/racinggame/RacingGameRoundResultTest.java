package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameRoundResultTest {

    @DisplayName("구성하는 값이 같으면 라운드의 결과는 같아야 한다.")
    @Test
    void equalsAndHashCode() {
        RacingGameRoundResult roundResult1 = new RacingGameRoundResult(
                List.of(
                        new RacingGameCarResult("car1", 0),
                        new RacingGameCarResult("car2", 1),
                        new RacingGameCarResult("car3", 2)
                )
        );
        RacingGameRoundResult roundResult2 = new RacingGameRoundResult(
                List.of(
                        new RacingGameCarResult("car1", 0),
                        new RacingGameCarResult("car2", 1),
                        new RacingGameCarResult("car3", 2)
                )
        );
        assertThat(roundResult1).isEqualTo(roundResult2);
    }

    @DisplayName("가장 멀리 있는 자동차의 이름을 반환해야 한다.")
    @Test
    void getFarthestCarNames() {
        RacingGameRoundResult round = new RacingGameRoundResult(
                List.of(
                        new RacingGameCarResult("car1", 0),
                        new RacingGameCarResult("car2", 2),
                        new RacingGameCarResult("car3", 1)
                )
        );
        assertThat(round.getFarthestCarNames()).containsExactly("car2");
    }

}
