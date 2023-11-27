package race.view;

import java.util.Scanner;

public class InputView {

    static Scanner scanner = new Scanner(System.in);

    public static int inputNumberOfCars() {
        System.out.print("자동차 대수 : ");
        return scanner.nextInt();
    }

    public static int inputNumberOfTry() {
        System.out.print("시도할 횟수 : ");
        return scanner.nextInt();
    }

}
