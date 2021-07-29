package carRacing;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    static void printNumberOfCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

    static void printNumberOfRacing() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

    static int inputNumber() {
        Scanner scanner = new Scanner(System.in);
        int number = -1;

        do {
            try {
                number = scanner.nextInt();
                if (number <= 0) {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println("0 이상의 정수값을 입력해주세요.");
                scanner.next();
            }

        } while (number <= 0);

        return number;
    }
}
