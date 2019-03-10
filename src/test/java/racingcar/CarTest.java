package racingcar;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;
import org.junit.Test;

public class CarTest {

    @Test
    public void test_checkCanMove() {
        int bound = 10;
        Random random = new Random();

        int randomNum = random.nextInt(bound);

        if (randomNum >= 4 && randomNum < 10) {
            assertThat(Car.checkCanMove(randomNum)).isEqualTo(true);
        }

        if (randomNum < 4 || randomNum >= 10) {
            assertThat(Car.checkCanMove(randomNum)).isEqualTo(false);
        }
    }
}