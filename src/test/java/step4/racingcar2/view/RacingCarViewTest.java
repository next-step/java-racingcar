package step4.racingcar2.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.racingcar.model.RacingCar;
import step3.racingcar.model.RacingCarEngine;
import step3.racingcar.view.RacingCarView;

public class RacingCarViewTest {

    private final ByteArrayOutputStream outStream = new ByteArrayOutputStream();

    @Test
    @DisplayName("RacingCarView::showCar() - GO")
    void givenAlwaysGoThreshold_whenRacingCarRun_thenRacingCarViewShow() {
        // given
        int no = 1;
        int threshold = 0;
        RacingCarEngine carEngine = new RacingCarEngine(threshold);
        RacingCar car = new RacingCar(no, carEngine);

        // when
        car.run();

        // then
        step3.racingcar.view.RacingCarView carView = new step3.racingcar.view.RacingCarView(car);
        System.setOut(new PrintStream(outStream));
        carView.showCar();
        assertEquals("Car #1 : - (1)\n", outStream.toString());
        System.setOut(System.out);
    }

    @Test
    @DisplayName("RacingCarView::carShow() - STOP")
    void givenAlwaysStopThreshold_whenRacingCarRun_thenRacingCarViewShow() {
        // given
        int no = 1;
        int threshold = 9;
        RacingCarEngine carEngine = new RacingCarEngine(threshold);
        RacingCar car = new RacingCar(no, carEngine);

        // when
        car.run();

        // then
        step3.racingcar.view.RacingCarView carView = new RacingCarView(car);
        System.setOut(new PrintStream(outStream));
        carView.showCar();
        assertEquals("Car #1 : (0)\n", outStream.toString());
        System.setOut(System.out);
    }

}
