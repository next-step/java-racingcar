package racingcar;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;
import org.junit.Test;

public class RacingCarTest {

    @Test
    public void test_checkCanMove() {
        int bound = 10;
        Random random = new Random();

        int randomNum = random.nextInt(bound);

        if (randomNum >= 4 && randomNum < 10) {
            assertThat(RacingCar.checkCanMove(randomNum)).isEqualTo(true);
        }

        if (randomNum < 4 || randomNum >= 10) {
            assertThat(RacingCar.checkCanMove(randomNum)).isEqualTo(false);
        }
    }

    @Test
    public void test_makeRandomMove() {
        RacingCar racingCar1 = new RacingCar();
        int moveSize1 = racingCar1.getMoves().size();

        RacingCar racingCar2 = racingCar1.makeRandomMove();
        int moveSize2 = racingCar2.getMoves().size();

        assertThat(racingCar1).isEqualTo(racingCar2);
        assertThat(moveSize1).isLessThan(moveSize2);
    }

    @Test
    public void test_translateMovesToPositions() {
        Random random = new Random();
        int randomNumTimes = random.nextInt(10) + 1;

        RacingCar racingCar1 = new RacingCar();

        for (int i = 0; i < randomNumTimes; i++) {
            racingCar1.makeRandomMove();
        }

        RacingCar racingCar2 = racingCar1.translateMovesToPositions();

        assertThat(racingCar1).isEqualTo(racingCar2);
        assertThat(racingCar2.getPositions().size()).isEqualTo(randomNumTimes+1);

        int randomNTime = random.nextInt(randomNumTimes);
        assertThat(racingCar2.getPositions().get(randomNTime)).isLessThanOrEqualTo(racingCar2.getPositions().get(randomNTime+1));
    }
}