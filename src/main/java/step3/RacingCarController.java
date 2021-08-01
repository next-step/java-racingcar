package step3;

import java.util.Scanner;

public class RacingCarController {

    private static final String ASK_INPUT_CARS = "자동차 대수는 몇 대 인가요?";
    private static final String ASK_INPUT_TRIES = "시도할 회수는 몇 회 인가요?";

    public static void run() {

        int cars = inputCars();
        int tries = inputTries();
        newLine();

        RacingCars racingCars = RacingCars.create(cars);
        OutputView.printResult(racingCars, tries);

    }

    public static int inputCars() {
        System.out.println(ASK_INPUT_CARS);
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static int inputTries() {
        System.out.println(ASK_INPUT_TRIES);
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private static void newLine() {
        System.out.println();
    }

}
