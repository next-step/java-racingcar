package study.racing;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    static Scanner scanner = null;

    public static int racingQuestion(String msg) {
        int carCount = 0;
        while (true) {
            try {
                scanner = new Scanner(System.in);
                System.out.println(msg);
                carCount = scanner.nextInt();
                if(carCount <= 0) {
                    throw new InputMismatchException();
                }
                return carCount;

            }catch (InputMismatchException e) {
                System.out.println(RacingMessage.TRY_AGAIN.msg());
            }
        }
    }
}
