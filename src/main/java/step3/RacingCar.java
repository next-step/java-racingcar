package step3;

import static step3.InputView.inputCountCar;
import static step3.InputView.inputTryCount;

public class RacingCar {
    public static void main(String[] args) {
        startRacing();
    }
    public static void startRacing(){
        int car[] = makeRacingCar(inputCountCar());
        int tryCount = makeTryCount(inputTryCount());
    }

    public static int[] makeRacingCar(int carCount){
        return new int[carCount];
    }

    public static int makeTryCount(int tryCount){
        return tryCount;
    }
}
