package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RacingCarTest {

    @Test
    @DisplayName("Input Test")
    public void input() {

        String input = "3\n5\n";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InputView inputView = new InputView();
        inputView.scan();

        assertThat(inputView.carCnt()).isEqualTo(3);
        assertThat(inputView.moveCnt()).isEqualTo(5);
    }

    @Test
    @DisplayName("Print Test")
    public void print() {

        RacingCar[] racingCars = new RacingCar[3];
        racingCars[0] = new RacingCar(1);
        racingCars[1] = new RacingCar(2);
        racingCars[2] = new RacingCar(3);

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        ResultView resultView = new ResultView();
        resultView.printTitle();
        resultView.printCarsDistance(racingCars);

        assertEquals("실행 결과\n-\n--\n---\n\n", out.toString());
    }

    @Test
    @DisplayName("Race Test")
    public void race() {

        RacingCar racingCar = new RacingCar(2);
        racingCar.race();

        assertTrue(racingCar.distance() == 2 || racingCar.distance() == 3);
    }
}
