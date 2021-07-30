package step3;

import java.util.Scanner;

public class RacingCarController {

    public static void run() {

        int cars = inputCars();
        int tries = inputTries();
        newLine();

        RacingCars racingCars = RacingCars.create(cars);
        OutputView.printResult(racingCars, tries);

    }

    public static int inputCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static int inputTries() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private static void newLine() {
        System.out.println();
    }

}
