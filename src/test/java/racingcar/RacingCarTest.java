package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

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
        racingcar.moveCarMovePosition(new Random());
        assertThat(racingcar.getCarMovePosition()).isBetween(0, 1);
    }

    @Test
    void racingComparatorOneTest() {
        Racingcar racingcar1 = new Racingcar(0, "일번");
        Racingcar racingcar2 = new Racingcar(1, "이번");

        racingcar1.moveCarMovePosition(new Random());
        for (int i = 0; i < 10; i++) {
            racingcar2.moveCarMovePosition(new Random());
        }
        int compare = racingcar1.compareTo(racingcar2);
        assertThat(compare).isEqualTo(1);
    }

    @Test
    void racingComparatorMinusTest() {
        Racingcar racingcar1 = new Racingcar(0, "일번");
        Racingcar racingcar2 = new Racingcar(1, "이번");

        racingcar2.moveCarMovePosition(new Random());
        for (int i = 0; i < 10; i++) {
            racingcar1.moveCarMovePosition(new Random());
        }
        int compare = racingcar1.compareTo(racingcar2);
        assertThat(compare).isEqualTo(0);
    }

}
