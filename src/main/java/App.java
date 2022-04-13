import racingcar.InputView;
import racingcar.RacingCar;
import racingcar.ResultView;

import java.util.Scanner;


public class App {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int participantCarNumber = InputView.enterTheNumberOfCars(scanner);
        int tryNumber = InputView.enterTheNumberOfTry(scanner);

        RacingCar racingCar = new RacingCar();
        ResultView.show(racingCar.start(participantCarNumber, tryNumber));
    }

}
