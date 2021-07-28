import step4.InputView;
import step4.Race;
import step4.ResultView;

import java.util.Scanner;

public class RacingCarMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String nameOfCar = inputView.getNameOfCar();
        int numOfCycle = inputView.getNumOfCycle();

        Race race = new Race(nameOfCar, numOfCycle);

        for (int i = 0; i < numOfCycle; i++) {
            race.printResult();
            race.playRace();
            System.out.println();
        }
        race.printResult();
        ResultView resultView = new ResultView();
        resultView.printFinalResult();
    }
}
