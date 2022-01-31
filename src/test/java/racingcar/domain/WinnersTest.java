package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class WinnersTest {

    @Test
    void 자동차_게임은_멀리_간_사람이_우승이다() {
        Winners winners = new Winners(
            Arrays.asList(new RacingCar("yang", 5), new RacingCar("woo", 3)));
        assertThat(winners.getRacingWinnerLists().get(0)).isEqualTo("yang");
    }

    @Test
    void 우승자는_한_명_이상일_수_있다() {
        Winners winners = new Winners(
            Arrays.asList(new RacingCar("yang", 5), new RacingCar("woo", 5)));
        assertThat(winners.getRacingWinnerLists().size()).isEqualTo(2);
    }
}
