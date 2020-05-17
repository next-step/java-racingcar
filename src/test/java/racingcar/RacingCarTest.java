package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @Test
    @DisplayName("자동차 생성 테스트")
    void createRacingCarTest() {
        Racingcar racingcar = new Racingcar(0, "이름");
        assertThat(0).isEqualTo(racingcar.getCarNumber());
        assertThat("이름").isEqualTo("이름");
    }

    @Test
    @DisplayName("자동차 이동 테스트")
    void moveRacingcarTest() {
        Racingcar racingcar = new Racingcar(0, "이름");
        racingcar.moveCarMovePosition(0);
        assertThat(racingcar.getCarMovePosition()).isBetween(0, 1);
    }

    @Test
    void racingComparatorTest() {
        Racingcar racingCarComparator = new Racingcar();

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
