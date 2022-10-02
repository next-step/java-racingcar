package thirdStep;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import thirdStep.View.InputView;
import thirdStep.logic.Race;

public class RacingCarTest {

    @Test
    @BeforeEach
    public void setUp() {
        InputView.carCount = 4;
    }

    @Test
    public void getRandomNumberTest() {
        int number = Race.getRandomNumber();
        assertThat(number).isBetween(0,9);
    }

    @Test
    public void carMoveTest() {
        int[] carStatus = Race.getCarStatus();
        Race.carMove(1, 4);
        assertThat(carStatus[1]).isEqualTo(1);
    }
}
