package step3;

import static step3.InputView.inputCountCar;
import static step3.InputView.inputTryCount;

import java.util.Random;

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

    public static boolean isMove(){
        Random random = new Random();
        int randomNumber = random.nextInt(10);
        if(randomNumber>=4){
            return true;
        }
        return false;
    }
}
