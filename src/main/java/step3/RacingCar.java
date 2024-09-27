package step3;

import static step3.InputView.inputCountCar;
import static step3.ResultView.printCarCount;

public class RacingCar {
    public static void startRacing(){
        printCarCount();
        int car[] = makeRacingCar(inputCountCar());
    }

    public static int[] makeRacingCar(int carCount){
        return new int[carCount];
    }
}
