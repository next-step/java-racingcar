package step3.view;

import java.util.Scanner;

public class InputView {

    private static int numberOfCars;
    private static int numberOfAttemps;

    public static void inputValues() {
        Scanner scan = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대인가요?");
        numberOfCars = scan.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        numberOfAttemps = scan.nextInt();
    }

    public static int getNumberOfCars() {
        return numberOfCars;
    }

    public static int getNumberOfAttemps() {
        return numberOfAttemps;
    }
}
