package step3;

import static step3.InputView.inputCountCar;
import static step3.InputView.inputTryCount;
import static step3.ResultView.printGoDistance;
import static step3.ResultView.printResultMessage;

import java.util.Random;

public class RacingCar {
    public static void main(String[] args) {
        startRacing();
    }
    public static void startRacing(){
        int car[] = makeRacingCar(inputCountCar());
        int tryCount = makeTryCount(inputTryCount());
        getGameResult(car, tryCount);
    }

    public static int[] makeRacingCar(int carCount){
        return new int[carCount];
    }

    public static int makeTryCount(int tryCount){
        return tryCount;
    }

    private static void getGameResult(int[] car, int tryCount) {
        printResultMessage();
        for(int i=0;i<tryCount;i++){
            car=carMove(car);

        }
    }

    private static int[] carMove(int[] car){
        for(int i=0;i<car.length;i++){
            if(isMove()){
                car[i]+=1;
            }
            printMove(car);
            System.out.println();
        }
        return car;
    }

    public static boolean isMove(){
        Random random = new Random();
        int randomNumber = random.nextInt(10);
        if(randomNumber>=4){
            return true;
        }
        return false;
    }

    public static void printMove(int[] car){
        for (int i=0;i<car.length;i++){
            printGoDistance(car[i]);
            System.out.println();
        }
    }
}
