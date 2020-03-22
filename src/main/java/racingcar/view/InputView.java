package racingcar.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static Scanner sc = new Scanner(System.in);
    private static int input;

    public static int carNumber() {
        message("자동차 대수는 몇 대 인가요?");
        return inputValidator();
    }

    public static int moveCount() {
        message("시도할 회수는 몇 회 인가요?");
        return inputValidator();
    }

    private static int inputValidator() {
        try {
            input = checkNumber(sc.nextInt());
        } catch (InputMismatchException e) {
            message("숫자만 입력가능합니다.");
            e.printStackTrace();
            inputClose();
        }
        return input;
    }

    private static int checkNumber(int input) {
        if (input < 1) {
            message("1보다 큰 숫자를 입력해 주세요.\n");
            carNumber();
        }
        return input;
    }

    private static void message(String message) {
        System.out.println(message);
    }


    public static void inputClose() {
        sc.close();
    }
}
