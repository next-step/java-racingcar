package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.model.RacingCar;
import racingCar.view.ResultView;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrintTest {

    @Test
    @DisplayName("[TEST] resultView.printCarsDistance()")
    public void printCarsDistanceTest() {

        List<RacingCar> racingCars = RacingCar.createMulti(3);
        racingCars.set(0, RacingCar.createWithDistance(1));
        racingCars.set(1, RacingCar.createWithDistance(2));
        racingCars.set(2, RacingCar.createWithDistance(3));

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        ResultView resultView = new ResultView();
        resultView.printResultTitle();
        resultView.printCarsDistance(racingCars);

        assertEquals("실행 결과\n-\n--\n---\n\n", out.toString());
    }

    @Test
    @DisplayName("[TEST] resultView.printCarsDistance() & resultView.printWinners()")
    public void printCarsDistanceAndPrintWinnersTest() {

        String[] carNames = new String[] { "pobi", "crong", "honux" };
        List<RacingCar> racingCars = RacingCar.createMulti(3);
        racingCars.set(0, RacingCar.createWithNameAndDistance(carNames[0], 1));
        racingCars.set(1, RacingCar.createWithNameAndDistance(carNames[1], 2));
        racingCars.set(2, RacingCar.createWithNameAndDistance(carNames[2], 3));

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        ResultView resultView = new ResultView();
        resultView.printResultTitle();
        resultView.printCarsNameAndDistance(racingCars);
        resultView.printRaceWinner(racingCars);

        assertEquals("실행 결과\npobi : -\ncrong : --\nhonux : ---\n\nhonux가 최종 우승했습니다.\n", out.toString());
    }
}
