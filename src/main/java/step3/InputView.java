package step3;

import static step3.ResultView.printCarCount;

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

}
