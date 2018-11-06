package racingCar;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;

public class RacingCarTest {


    @Test
    public void isgoing() {
        boolean result = RacingCar.isgoing(1);
        assertFalse(result);
    }

    @Test
    public void moveCount(){
        int result = RacingCar.move(7);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void changeCarPosition(){
        int[] result = {0,0,0};
        result[0] += RacingCar.move(6);
        result[1] += RacingCar.move(3);
        result[2] += RacingCar.move(8);

        assertArrayEquals(new int[]{1,0,1},result);
    }

    @Test
    public void 자동차나누기(){
        String[] result = RacingCar.splitCarList("pobi,crong,honux");
        assertArrayEquals(new String[]{"pobi", "crong", "honux"}, result);
    }


}