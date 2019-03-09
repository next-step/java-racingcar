package racingcar;

import java.util.Random;
import java.util.Scanner;

public class RacingCar {
    private static final int BOUND = 10;
    private static Random random = new Random();

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("자동차 대수는 몇 대 인가요?");
        int numberOfCars = scanner.nextInt();

        System.out.print("시도할 회수는 몇 회 인가요?");
        int numberOfTimes = scanner.nextInt();

        int[][] positionsOfCars = makeMoveOfCars(numberOfCars, numberOfTimes);

        showGame(positionsOfCars);
    }

    private static void showGame(int[][] positionsOfCars) {

        for (int[] positionsOfCar : positionsOfCars) {
            for (int position : positionsOfCar) {
                if (checkCanMove(position)) {
                    System.out.print("_");
                }
            }

            System.out.println();
        }


    }

    private static int[][] makeMoveOfCars(int numberOfCars, int numberOfTimes) {
        int[][] positionsOfCars = new int[numberOfTimes][numberOfCars];

        for (int times = 0; times < numberOfTimes; times++) {
            for (int i = 0; i < numberOfCars; i++) {
                positionsOfCars[times][i] = generateRandomInt();
            }
        }

        return positionsOfCars;
    }

    private static int generateRandomInt() {
        return random.nextInt(BOUND);
    }

    private static boolean checkCanMove(int num) {

        if (num >= 4 && num <= 10) {
            return true;
        }

        return false;
    }
}
