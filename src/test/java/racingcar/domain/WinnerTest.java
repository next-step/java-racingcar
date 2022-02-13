package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class WinnerTest {
    @Test
    void 가장_많이_전진한_자동차가_우승한다() {
        Winner winners = new Winner(new Cars(Arrays.asList(new Car("seung", 8)
            , new Car("yeon", 2))));
        winners.setWinners();
        assertThat(winners.getWinners().get(0).getName()).isEqualTo("seung");
    }
}
