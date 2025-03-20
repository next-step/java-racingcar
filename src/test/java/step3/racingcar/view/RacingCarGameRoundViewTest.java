package step3.racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.racingcar.controller.RacingCarGameRoundController;
import step3.racingcar.model.RacingCar;
import step3.racingcar.model.RacingCarEngine;
import step3.racingcar.model.RacingCarGameRound;

public class RacingCarGameRoundViewTest {

    private final ByteArrayOutputStream outStream = new ByteArrayOutputStream();

    @Test
    @DisplayName("RacingCarGameRound::printRoundResult()")
    void givenRacingCarGameRound_whenPrintRoundResult_thenPrintRoundResult() {
        // given
        int alwaysGoThreshold = 0;
        int alwaysStopThreshold = 10;
        RacingCarGameRound gameRound = new RacingCarGameRound(1,
            new RacingCar[]{new RacingCar(1, new RacingCarEngine(alwaysGoThreshold)),
                new RacingCar(2, new RacingCarEngine(alwaysStopThreshold)),
                new RacingCar(3, new RacingCarEngine(alwaysStopThreshold)),});

        // when
        RacingCarGameRoundController roundController = new RacingCarGameRoundController();
        roundController.roundReady(gameRound);
        roundController.roundStart();

        // then
        RacingCarGameRoundView roundView = new RacingCarGameRoundView(gameRound);
        System.setOut(new PrintStream(outStream));
        roundView.showRound();
        assertEquals("\nRound #1\n" + "Car #1 : - (1)\n" + "Car #2 : (0)\n" + "Car #3 : (0)\n",
            outStream.toString());
        System.setOut(System.out);
    }

}
