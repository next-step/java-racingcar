package RacingCar;

import java.util.Random;
import java.util.Scanner;

public class RacingCar {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args){
        int carCount = carCountScan();
        int round = roundScan();

        //경주

        //resultView
        //결과 출력
    }

    private static int roundScan() {
        InputView.roundView();
        return scan();
    }

    private static int carCountScan() {
        InputView.carCountView();
        return scan();
    }

    public static int random() {
        return random.nextInt(10);
    }

    public static int scan() {
        return scanner.nextInt();
    }

    public static int move() {
        int result = random();

        if(result >= 4){
            return 1;
        }

        return 0;
    }
}
