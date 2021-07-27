import step4.InputView;
import step4.Race;

import java.util.Scanner;

public class RacingCarMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int numOfCar = inputView.getNumOfCar();
        int numOfCycle = inputView.getNumOfCycle();

        Race race = new Race(numOfCar, numOfCycle);

        for (int i = 0; i < numOfCycle; i++) {
            race.printResult();
            race.playRace();
            System.out.println();
        }
        race.printResult();
    }
}
