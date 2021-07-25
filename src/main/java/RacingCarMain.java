import racing.RacingCarInput;
import racing.RacingCarOperator;
import step3.controller.RaceManager;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.Scanner;

public class RacingCarMain {
    static int numOfCar;
    static int numOfCycle;

    public static void main(String[] args) {
        RacingCarMain rcm = new RacingCarMain();
        rcm.prepareInput();
    }

    private void prepareInput() {
        InputView iv = new InputView();
        numOfCar = iv.getNumOfCar();
        numOfCycle = iv.getNumOfCycle();

        RaceManager rm = new RaceManager(numOfCar, numOfCycle);
        raceStart(rm);
    }

    private void raceStart(RaceManager rm) {
        rm.inputCheck();
        rm.makeCarAry();
        rm.raceByCycle();
    }


}
