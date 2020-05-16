package util;

import org.junit.jupiter.api.Test;
import racingcar.Racingcar;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarComparatorTest {

    @Test
    void racingComparatorTest() {
        RacingCarComparator racingCarComparator = new RacingCarComparator();
        Racingcar racingcar1 = new Racingcar(0, "일번");
        racingcar1.setCarMovePosition(5);
        Racingcar racingcar2 = new Racingcar(1, "이번");
        racingcar2.setCarMovePosition(7);
        Racingcar racingcar3 = new Racingcar(2, "삼번");
        racingcar3.setCarMovePosition(10);


        int compare = racingCarComparator.compare(racingcar1, racingcar2);
        assertThat(compare).isEqualTo(1);


        compare = racingCarComparator.compare(racingcar3, racingcar1);
        assertThat(compare).isEqualTo(0);
    }
}
