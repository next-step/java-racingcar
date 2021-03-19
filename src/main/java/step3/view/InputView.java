package step3.view;

import java.util.Scanner;

public class InputView {

    private static int cars;
    private static int attemps;

    public static void inputValues() {
        Scanner scan = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대인가요?");
        cars = scan.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        attemps = scan.nextInt();
    }

    public static int getNumberOfCars() {
        return cars;
    }

    public static int getAttemps() {
        return attemps;
    }
}
