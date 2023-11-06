package step3;

import step3.controller.MyScanner;
import step3.controller.ScannerInterface;
import step3.model.Car;
import step3.model.CarRacingPlay;
import step3.model.MyRandomValueGenerator;
import step3.controller.CarRacingInputController;
import step3.view.ResultView;

import java.util.List;
import java.util.Scanner;

public class CarRacing {


    private static final ScannerInterface myScanner = new MyScanner(new Scanner(System.in));

    public static void main(String[] args) {

        CarRacingInputController carRacingInputController = new CarRacingInputController(myScanner);
        int attendCarNumber = carRacingInputController.inputParticipantCarNumber();
        int totalRacingRound = carRacingInputController.inputRacingChance();

        CarRacingPlay carRacingPlay = new CarRacingPlay(new MyRandomValueGenerator(), attendCarNumber);

        ResultView.printRacingResultStartText();
        for (int i = 0; i < totalRacingRound; i++) {
            List<Car> cars = carRacingPlay.raceOneCycle();
            ResultView.printRacingStatus(cars);
        }
    }
}
