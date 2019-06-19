package homework.week1;

import java.util.Scanner;

public class RacingCarGameFront {
    private static final String RUN_SYMBOL = "-";

    public static void main(String[] args) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        int numbersOfCars = scanner.nextInt();
        System.out.println("경주 할 회수는 몇 회 인가요?");
        int numbersOfRacing = scanner.nextInt();
        RacingCarGameEngine carGameEngine = new RacingCarGameEngine(numbersOfRacing, new int[numbersOfCars]);
    }

    void printRacingCars(int[] carPositions) {
        for (int carPosition : carPositions) {
            printRunCar(carPosition);
        }
        System.out.println();
    }

    void printRunCar(int runCount) {
        for (int count = 0; count < runCount; count++) {
            System.out.print(RUN_SYMBOL);
        }
        System.out.println();
    }
}
