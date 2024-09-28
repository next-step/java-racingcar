package step3;

import static step3.ResultView.printCarCount;
import static step3.ResultView.printTryCount;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    public static int inputCountCar() {
        Scanner scanner = new Scanner(System.in);
        int carCount = 0;
        boolean isValid = false;
        while (!isValid) {
            printCarCount();
            try {
                carCount = scanner.nextInt();
                isValid = isPositiveNum(carCount);
            } catch (InputMismatchException ex) {
                scanner.next();
            }
        }
        return carCount;
    }

    public static boolean isPositiveNum(int num) {
        if (num <= 0) {
            return false;
        }
        return true;
    }

    public static int inputTryCount() {
        Scanner scanner = new Scanner(System.in);
        int tryCount = 0;
        boolean isValid = false;
        while (!isValid) {
            printTryCount();
            try {
                tryCount = scanner.nextInt();
                isValid = isPositiveNum(tryCount);
            } catch (InputMismatchException ex) {
                scanner.next();
            }
        }
        return tryCount;
    }
}
