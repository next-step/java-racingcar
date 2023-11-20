package step4.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class WinnersTest {

    @Test
    @DisplayName("경기 종료 후, 우승자를 구한다.")
    void findWinners() {
        Cars cars = new Cars(new String[]{"귤", "오렌지", "망고" }, new int[]{1, 3, 1});
        Winners winners = new Winners();

        Assertions.assertThat(winners.findWinners(cars)).containsExactly(new Name("오렌지"));
    }
}
