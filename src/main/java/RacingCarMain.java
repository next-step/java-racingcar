import step4.Race;

import java.util.Scanner;

public class RacingCarMain {
    public static void main(String[] args) {
        Race race = new Race();
        int numOfCar = race.getNumOfCar();
        int numOfCycle = race.getNumOfCycle();

        race.validInputConfirm();
        race.prepareCars();

        for (int i = 0; i < numOfCycle; i++) {
            race.printResult();
            race.playRace();
            System.out.println();
        }
        race.printResult();
    }
}
