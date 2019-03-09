package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;
import org.junit.Test;

public class RacingCarTest {

    @Test
    public void test_makeMoveOfCars() {
        int numTimes = 3, numCars = 5;
        int[][] result = RacingCar.makeMoveOfCars(numCars, numTimes);

        assertThat(result.length).isEqualTo(numTimes);
        assertThat(result[new Random().nextInt(numTimes)].length).isEqualTo(numCars);

        int timeN = new Random().nextInt(numTimes-1);
        int carN = new Random().nextInt(numCars);

        while (timeN < 1) {
            timeN = new Random().nextInt(numTimes-1);
        }

        assertThat(result[timeN][carN]).isGreaterThanOrEqualTo(result[timeN-1][carN]);
        assertThat(result[timeN][carN]).isLessThanOrEqualTo(result[timeN+1][carN]);
    }

    @Test
    public void test_generateRandomNum() {
        assertThat(RacingCar.generateRandomNum()).isBetween(0, 9);
    }

    @Test
    public void test_checkCanMove() {
        assertThat(RacingCar.checkCanMove(8)).isEqualTo(true);
        assertThat(RacingCar.checkCanMove(3)).isEqualTo(false);
        assertThat(RacingCar.checkCanMove(10)).isEqualTo(false);
    }
}