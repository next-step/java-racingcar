package racing;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class RacingGame {

    private static int timeToTry;
    private static int numberOfCar;
    private static int[] carPositions;

    public static void inputView() {
        System.out.println("자동차 대수는 몇 대인가요?");

        Scanner scanner = new Scanner(System.in);
        numberOfCar = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회인가요?");
        timeToTry = scanner.nextInt();

    }

    public static void resultView() {

        int time = 0;

        if(time == 0) {
            System.out.println("실행 결과");
        }

        while(time < timeToTry) {
            moveCars();
            oneTryView();
            time++;
        }
    }

    public static int[] initCars() {
        carPositions = new int[numberOfCar];
        Arrays.fill(carPositions, 0);
        return carPositions;
    }



    public static int[] moveCars() {
        for(int i = 0 ; i < carPositions.length ; i++) {
            if (new Random().nextInt(10) >= 4) {
                carPositions[i]++;
            }
        }
        return carPositions;
    }

    public static void oneTryView() {
        for(int carPosition : carPositions) {
            for(int i = 0 ; i < carPosition ; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int getTimeToTry() {
        return timeToTry;
    }

    public static int getNumberOfCar() {
        return numberOfCar;
    }

    public static int[] getCarPositions() {
        return carPositions;
    }

    public static void setTimeToTry(int timeToTry) {
        RacingGame.timeToTry = timeToTry;
    }

    public static void setNumberOfCar(int numberOfCar) {
        RacingGame.numberOfCar = numberOfCar;
    }

    public static void setCarPositions(int[] carPositions) {
        RacingGame.carPositions = carPositions;
    }
}
