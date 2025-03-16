package step3.racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.racingcar.model.RacingCar;
import step3.racingcar.model.RacingCarResult;

public class RacingCarTest {

    private final ByteArrayOutputStream outStream = new ByteArrayOutputStream();

    @Test
    @DisplayName("RacingCar Run(=GO) Test")
    void givenRandomSeed_whenRacingCarRun_thenRacingCarGo() {
        // given
        int no = 2;
        int randomSeed = 6;

        // when
        RacingCar car = new RacingCar(no, randomSeed);
        car.run();

        // then
        assertThat(car.roundResult()).isEqualTo(RacingCarResult.GO);
    }

    @Test
    @DisplayName("RacingCar Show(=GO) Test")
    void givenRandomSeed_whenRacingCarRun_thenRacingCarGoShow() {
        // given
        int no = 2;
        int randomSeed = 6;

        // when
        RacingCar car = new RacingCar(no, randomSeed);
        car.run();

        // then
        System.setOut(new PrintStream(outStream));
        car.show();
        assertEquals("Car #2 [ GO ] : - (1)\n", outStream.toString());
        System.setOut(System.out);
    }

    @Test
    @DisplayName("RacingCar Run(=STOP) Test")
    void givenRandomSeed_whenRacingCarRun_thenRacingCarStop() {
        // given
        int no = 2;
        int randomSeed = 8;

        // when
        RacingCar car = new RacingCar(no, randomSeed);
        car.run();

        // then
        assertThat(car.roundResult()).isEqualTo(RacingCarResult.STOP);
    }

    @Test
    @DisplayName("RacingCar Show(=STOP) Test")
    void givenRandomSeed_whenRacingCarRun_thenRacingCarStopShow() {
        // given
        int no = 2;
        int randomSeed = 8;

        // when
        RacingCar car = new RacingCar(no, randomSeed);
        car.run();

        // then
        System.setOut(new PrintStream(outStream));
        car.show();
        assertEquals("Car #2 [STOP] : (0)\n", outStream.toString());
        System.setOut(System.out);
    }

}
